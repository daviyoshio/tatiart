// Debug: Log quando o script começa a executar
console.log('Script sobre-a-tati.js iniciando...');

// Aguarda o carregamento completo da página
window.onload = function() {
    // Função para carregar a galeria
    function loadGallery() {
        const gallery = document.getElementById('gallery-container');
        const loadMoreBtn = document.getElementById('load-more-btn');
        const showLessBtn = document.getElementById('show-less-btn');
        if (!gallery || !loadMoreBtn || !showLessBtn) return;

        const images = [
            { url: '/images/Sobre-Tati/800x800 Caneca do Amor (1).png', alt: 'Caneca do Amor (1)' },
            { url: '/images/Sobre-Tati/800x800 Caneca do Amor.png', alt: 'Caneca do Amor' },
            { url: '/images/Sobre-Tati/800x800 Bolsa Tote Verde.png', alt: 'Bolsa Tote Verde' },
            { url: '/images/Sobre-Tati/800x800 Bolsa Mulheres Experience.png', alt: 'Bolsa Mulheres Experience' },
            { url: '/images/Sobre-Tati/800x800 Bolsa Pequena Couro.png', alt: 'Bolsa Pequena Couro' },
            { url: '/images/Sobre-Tati/800x800 Estojo Ady.png', alt: 'Estojo Ady' },
            { url: '/images/Sobre-Tati/800x800 Estojo Abelhinnha.png', alt: 'Estojo Abelhinnha' },
            { url: '/images/Sobre-Tati/800x800 Lancheira Frozen.png', alt: 'Lancheira Frozen' },
            { url: '/images/Sobre-Tati/800x800 Necessaire Dra Aniledys.png', alt: 'Necessaire Dra Aniledys' },
            { url: '/images/Sobre-Tati/800x800 Necessaire Jesus.png', alt: 'Necessaire Jesus' },
            { url: '/images/Sobre-Tati/800x800 Necessaire Estampada.png', alt: 'Necessaire Estampada' },
            { url: '/images/Sobre-Tati/800x800 Linha Baby Helena.png', alt: 'Linha Baby Helena' },
            { url: '/images/Sobre-Tati/800x800 Linha Baby Violeta.png', alt: 'Linha Baby Violeta' },
            { url: '/images/Sobre-Tati/800x800 Mochila Tigrinho.png', alt: 'Mochila Tigrinho' },
            { url: '/images/Sobre-Tati/800x800 Mochila e Estojo Unicórnio.png', alt: 'Mochila e Estojo Unicórnio' },
            { url: '/images/Sobre-Tati/800x800 Canecas Mae Avó (1).png', alt: 'Canecas Mae Avó (1)' },
            { url: '/images/Sobre-Tati/800x800 Canecas Mae Avó.png', alt: 'Canecas Mae Avó' },
            { url: '/images/Sobre-Tati/800x800 Canecas Tiago e Fernando.png', alt: 'Canecas Tiago e Fernando' },
            { url: '/images/Sobre-Tati/800x800 Necessaire Premium Aberta.png', alt: 'Necessaire Premium Aberta' },
            { url: '/images/Sobre-Tati/800x800 Mochila Kit Mickey.png', alt: 'Mochila Kit Mickey' }
          ];

        let currentPage = 0;
        const imagesPerPage = 8;

        function updateGallery() {
            // Limpa a galeria
            gallery.innerHTML = '';
            
            // Calcula quantas imagens mostrar
            const end = (currentPage + 1) * imagesPerPage;
            const currentImages = images.slice(0, end);

            // Adiciona as imagens
            currentImages.forEach(image => {
                gallery.insertAdjacentHTML('beforeend', `
                    <div class="relative overflow-hidden rounded-lg aspect-square cursor-pointer group">
                        <img src="${image.url}" alt="${image.alt}" 
                             class="w-full h-full object-cover transition-transform duration-300 group-hover:scale-105">
                        <div class="absolute inset-0 bg-burgundy-800 opacity-0 group-hover:opacity-20 transition-opacity duration-300"></div>
                    </div>
                `);
            });

            // Atualiza a visibilidade dos botões
            if (end >= images.length) {
                loadMoreBtn.classList.add('hidden');
            } else {
                loadMoreBtn.classList.remove('hidden');
            }

            // Mostra o botão "Ver menos" apenas se houver mais que imagesPerPage imagens
            if (currentImages.length > imagesPerPage) {
                showLessBtn.classList.remove('hidden');
            } else {
                showLessBtn.classList.add('hidden');
            }
        }

        // Carrega o estado inicial
        updateGallery();

        // Evento para carregar mais imagens
        loadMoreBtn.addEventListener('click', () => {
            currentPage++;
            updateGallery();
        });

        // Evento para mostrar menos imagens
        showLessBtn.addEventListener('click', () => {
            currentPage = 0; // Volta ao estado inicial
            updateGallery();
            
            // Scroll suave de volta ao topo da galeria
            gallery.scrollIntoView({ behavior: 'smooth' });
        });
    }

    // Função para animações
    function setupAnimations() {
        const animatedElements = document.querySelectorAll('.animate-on-scroll');
        
        const observer = new IntersectionObserver(
            entries => {
                entries.forEach(entry => {
                    if (entry.isIntersecting) {
                        entry.target.classList.add('animate-fadeIn');
                    }
                });
            },
            { threshold: 0.1 }
        );

        animatedElements.forEach(el => observer.observe(el));
    }

    // Inicializa as funcionalidades
    loadGallery();
    setupAnimations();

    // Debug: Verifica o estado final da página
    console.log('Script finalizado, verificando conteúdo final da página...');
    const finalContent = document.body.innerHTML;
    console.log('Conteúdo final da página está presente:', finalContent.length > 0);
};