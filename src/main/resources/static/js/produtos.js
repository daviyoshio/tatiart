document.addEventListener('DOMContentLoaded', function() {
  // Mobile menu toggle functionality
  const mobileMenuButton = document.getElementById('mobile-menu-button');
  const mobileMenu = document.getElementById('mobile-menu');

  if (mobileMenuButton && mobileMenu) {
    mobileMenuButton.addEventListener('click', function() {
      mobileMenu.classList.toggle('hidden');
    });
  }

  // FAQ toggle functionality
  const faqToggles = document.querySelectorAll('.faq-toggle');
  
  faqToggles.forEach(toggle => {
    toggle.addEventListener('click', function() {
      const content = this.nextElementSibling;
      const icon = this.querySelector('i');
      
      // Toggle the content visibility
      content.classList.toggle('hidden');
      
      // Toggle the icon rotation
      if (content.classList.contains('hidden')) {
        icon.style.transform = 'rotate(0deg)';
      } else {
        icon.style.transform = 'rotate(180deg)';
      }
    });
  });

  // Enhanced Carousel functionality
  const carouselContainers = document.querySelectorAll('.carousel-container');
  
  carouselContainers.forEach(container => {
    const prevButton = container.parentElement.querySelector('.carousel-prev');
    const nextButton = container.parentElement.querySelector('.carousel-next');
    
    // Calculate scroll amount based on container width and item width
    const getScrollAmount = () => {
      const containerWidth = container.offsetWidth;
      const itemWidth = container.querySelector('div').offsetWidth;
      return Math.min(itemWidth + 16, containerWidth); // 16px for gap
    };
    
    if (prevButton && nextButton) {
      prevButton.addEventListener('click', () => {
        const scrollAmount = getScrollAmount();
        container.scrollBy({ 
          left: -scrollAmount, 
          behavior: 'smooth' 
        });
      });
      
      nextButton.addEventListener('click', () => {
        const scrollAmount = getScrollAmount();
        container.scrollBy({ 
          left: scrollAmount, 
          behavior: 'smooth' 
        });
      });
      
      // Update button states based on scroll position
      const updateButtonStates = () => {
        const isAtStart = container.scrollLeft <= 0;
        const isAtEnd = container.scrollLeft >= (container.scrollWidth - container.offsetWidth - 1);
        
        prevButton.style.opacity = isAtStart ? '0.5' : '1';
        nextButton.style.opacity = isAtEnd ? '0.5' : '1';
        prevButton.style.cursor = isAtStart ? 'not-allowed' : 'pointer';
        nextButton.style.cursor = isAtEnd ? 'not-allowed' : 'pointer';
      };
      
      // Initial button state update
      updateButtonStates();
      
      // Update button states on scroll
      container.addEventListener('scroll', updateButtonStates);
      
      // Update button states on window resize
      window.addEventListener('resize', updateButtonStates);
    }
    
    // Touch/swipe support for mobile
    let isDown = false;
    let startX;
    let scrollLeft;
    
    container.addEventListener('mousedown', (e) => {
      isDown = true;
      startX = e.pageX - container.offsetLeft;
      scrollLeft = container.scrollLeft;
      container.style.cursor = 'grabbing';
    });
    
    container.addEventListener('mouseleave', () => {
      isDown = false;
      container.style.cursor = 'grab';
    });
    
    container.addEventListener('mouseup', () => {
      isDown = false;
      container.style.cursor = 'grab';
    });
    
    container.addEventListener('mousemove', (e) => {
      if (!isDown) return;
      e.preventDefault();
      const x = e.pageX - container.offsetLeft;
      const walk = (x - startX) * 2;
      container.scrollLeft = scrollLeft - walk;
    });
    
    // Touch events for mobile
    let touchStartX = 0;
    let touchStartScrollLeft = 0;
    
    container.addEventListener('touchstart', (e) => {
      touchStartX = e.touches[0].clientX;
      touchStartScrollLeft = container.scrollLeft;
    });
    
    container.addEventListener('touchmove', (e) => {
      if (!touchStartX) return;
      
      const touchX = e.touches[0].clientX;
      const diff = touchStartX - touchX;
      container.scrollLeft = touchStartScrollLeft + diff;
    });
    
    container.addEventListener('touchend', () => {
      touchStartX = 0;
    });
  });

  // Smooth scrolling for anchor links
  document.querySelectorAll('a[href^="#"]').forEach(anchor => {
    anchor.addEventListener('click', function(e) {
      if (this.getAttribute('href') !== '#') {
        e.preventDefault();
        
        const targetId = this.getAttribute('href');
        const targetElement = document.querySelector(targetId);
        
        if (targetElement) {
          const headerHeight = document.querySelector('header').offsetHeight;
          const elementPosition = targetElement.getBoundingClientRect().top;
          const offsetPosition = elementPosition + window.pageYOffset - headerHeight - 20;
          
          window.scrollTo({
            top: offsetPosition,
            behavior: 'smooth'
          });
          
          // Close mobile menu if it's open
          if (mobileMenu && !mobileMenu.classList.contains('hidden')) {
            mobileMenu.classList.add('hidden');
          }
        }
      }
    });
  });

  // Intersection Observer for animations
  const observerOptions = {
    threshold: 0.1,
    rootMargin: '0px 0px -50px 0px'
  };

  const observer = new IntersectionObserver((entries) => {
    entries.forEach(entry => {
      if (entry.isIntersecting) {
        entry.target.style.opacity = '1';
        entry.target.style.transform = 'translateY(0)';
      }
    });
  }, observerOptions);

  // Observe elements for animation
  document.querySelectorAll('.carousel-container > div').forEach(el => {
    el.style.opacity = '0';
    el.style.transform = 'translateY(20px)';
    el.style.transition = 'opacity 0.6s ease, transform 0.6s ease';
    observer.observe(el);
  });
});