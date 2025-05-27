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
            { url: 'https://images.unsplash.com/photo-1616046229478-9901c5536a45?w=500', alt: 'Projeto artesanal 1' },
            { url: 'https://images.unsplash.com/photo-1581091226825-a6a2a5aee158?w=500', alt: 'Projeto artesanal 2' },
            { url: 'https://images.unsplash.com/photo-1581090464777-f3220bbe1b8b?w=500', alt: 'Projeto artesanal 3' },
            { url: 'https://images.unsplash.com/photo-1500673922987-e212871fec22?w=500', alt: 'Projeto artesanal 4' },
            { url: 'https://images.unsplash.com/photo-1506744038136-46273834b3fb?w=500', alt: 'Projeto artesanal 5' },
            { url: 'https://images.unsplash.com/photo-1510832198440-a52376950479?w=500', alt: 'Projeto artesanal 6' },
            { url: 'https://images.unsplash.com/photo-1649972904349-6e44c42644a7?w=500', alt: 'Projeto artesanal 7' },
            { url: 'https://images.unsplash.com/photo-1618220179428-22790b461013?w=500', alt: 'Projeto artesanal 8' },
            // Segunda página
            { url: 'https://images.unsplash.com/photo-1464822759023-fed622ff2c3b?w=500', alt: 'Projeto artesanal 9' },
            { url: 'https://images.unsplash.com/photo-1513519245088-0e12902e5a38?w=500', alt: 'Projeto artesanal 10 - Artesanato' },
            { url: 'https://images.unsplash.com/photo-1604014237800-1c9102c219da?w=500', alt: 'Projeto artesanal 11 - Trabalho Manual' },
            { url: 'https://images.unsplash.com/photo-1470229722913-7c0e2dbbafd3?w=500', alt: 'Projeto artesanal 12' },
            // Terceira página (novas imagens)
            { url: 'https://images.unsplash.com/photo-1528605105345-5344ea20e269?w=500', alt: 'Projeto artesanal 13' },
            { url: 'https://images.unsplash.com/photo-1490312278390-ab64016e0aa9?w=500', alt: 'Projeto artesanal 14' },
            { url: 'https://images.unsplash.com/photo-1516981442399-a91139e20ff8?w=500', alt: 'Projeto artesanal 15' },
            { url: 'https://images.unsplash.com/photo-1595341888016-a392ef81b7de?w=500', alt: 'Projeto artesanal 16' },
            { url: 'https://images.unsplash.com/photo-1606760227091-3dd870d97f1d?w=500', alt: 'Projeto artesanal 17' },
            { url: 'https://images.unsplash.com/photo-1516727003284-a96541e51e9c?w=500', alt: 'Projeto artesanal 18' },
            { url: 'https://images.unsplash.com/photo-1464699908537-0954e50791ee?w=500', alt: 'Projeto artesanal 19' },
            { url: 'https://images.unsplash.com/photo-1464699908537-0954e50791ee?w=500', alt: 'Projeto artesanal 20' }
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