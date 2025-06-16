package br.com.tatiart.model;

import br.com.tatiart.repository.CategoriaRepository;
import br.com.tatiart.repository.CategoriaTranslationRepository;
import br.com.tatiart.repository.DepoimentoRepository;
import br.com.tatiart.repository.ItemPersonalizacaoRepository;
import br.com.tatiart.repository.ItemPersonalizacaoTranslationRepository;
import br.com.tatiart.repository.ProdutoRepository;
import br.com.tatiart.repository.ProdutoTranslationRepository;
import br.com.tatiart.repository.TipoPersonalizacaoRepository;
import br.com.tatiart.repository.TipoPersonalizacaoTranslationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    // Injeção de todos os repositórios necessários
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private DepoimentoRepository depoimentoRepository;
    @Autowired
    private TipoPersonalizacaoRepository tipoPersonalizacaoRepository;
    @Autowired
    private CategoriaTranslationRepository categoriaTranslationRepository;
    @Autowired
    private ProdutoTranslationRepository produtoTranslationRepository;
    @Autowired
    private TipoPersonalizacaoTranslationRepository tipoPersonalizacaoTranslationRepository;
    @Autowired
    private ItemPersonalizacaoRepository itemPersonalizacaoRepository;
    @Autowired
    private ItemPersonalizacaoTranslationRepository itemPersonalizacaoTranslationRepository;

    @Override
    public void run(String... args) throws Exception {
        // Limpa o banco de dados na ordem correta para evitar erros
        itemPersonalizacaoTranslationRepository.deleteAllInBatch();
        itemPersonalizacaoRepository.deleteAllInBatch();
        tipoPersonalizacaoTranslationRepository.deleteAllInBatch();
        tipoPersonalizacaoRepository.deleteAllInBatch();
        depoimentoRepository.deleteAllInBatch();
        produtoTranslationRepository.deleteAllInBatch();
        produtoRepository.deleteAllInBatch();
        categoriaTranslationRepository.deleteAllInBatch();
        categoriaRepository.deleteAllInBatch();

        // --- Adiciona todas as categorias aqui ---
        criarCategoriaNecessaires();
        criarCategoriaCanecas();
        criarCategoriaBolsas();
        criarCategoriaEstojos();
        criarCategoriaMochilas();
        criarCategoriaLinhaBaby(); // Adicionando a nova categoria
    }

    private void criarCategoriaNecessaires() {
        // --- CATEGORIA NECESSAIRES ---
        Categoria necessaires = new Categoria();
// 1. Defina os campos que NÃO são traduzidos

        necessaires.setSlug(
                "necessaires");
        necessaires.setImagemDestaqueUrl(
                "/images/Produtos/Necessaires/Necessaire Gatinho.jpeg");
        necessaires.setUrlImagemPersonalizacao(
                "/images/Produtos/Necessaires/Necessaire Premium.jpeg");
        necessaires.setImagemUrlHome(
                "/images/Home/Necessaire - Categoria.png");

// 2. Crie a tradução para Português (pt-BR)
        CategoriaTranslation ptNecessaires = new CategoriaTranslation();

        ptNecessaires.setLocale(
                "pt-BR");
        ptNecessaires.setCategoria(necessaires); // Associa à categoria pai

        ptNecessaires.setNomeSingular(
                "Necessaire");
        ptNecessaires.setNomePlural(
                "Necessaires Personalizadas");
        ptNecessaires.setDescricao(
                "Transforme sua rotina com necessaires 100% personalizadas. Cada peça é única, criada especialmente para refletir sua personalidade e organizar seus momentos mais importantes.");
        ptNecessaires.setCtaTitle(
                "Sua Rotina Merece Essa Transformação...");
        ptNecessaires.setCtaDescription(
                "A organização muda tudo na sua vida. Que tal transformar sua rotina em algo mais prático e estiloso? Sua necessaire personalizada está a apenas um clique de distância. Vamos organizar juntas?");
        ptNecessaires.setCtaAttention(
                "⚡ ATENÇÃO: Devido à alta demanda, estamos com prazo de entrega de 3-5 dias. Garante já a sua antes que o prazo aumente!");
        ptNecessaires.setCtaButtonText(
                "✨ SIM! Quero Minha Necessaire Personalizada");
        ptNecessaires.setHeroTitle(
                "Necessaires que Organizam Sua Vida com Estilo");
        ptNecessaires.setHeroButtonText(
                "💝 Criar Minha Necessaire");
        ptNecessaires.setGaleriaTitle(
                "Cada Necessaire Conta Sua História");
        ptNecessaires.setGaleriaDescricao(
                "Veja como transformamos ideias simples em necessaires que organizam com amor. Cada detalhe é pensado para facilitar sua rotina e expressar quem você é.");

// 3. Crie a tradução para Inglês (en)
        CategoriaTranslation enNecessaires = new CategoriaTranslation();

        enNecessaires.setLocale(
                "en");
        enNecessaires.setCategoria(necessaires); // Associa à categoria pai

        enNecessaires.setNomeSingular(
                "Pouch");
        enNecessaires.setNomePlural(
                "Custom Pouches");
        enNecessaires.setDescricao(
                "Transform your routine with 100% custom pouches. Each piece is unique, specially created to reflect your personality and organize your most important moments.");
        enNecessaires.setCtaTitle(
                "Your Routine Deserves This Transformation...");
        enNecessaires.setCtaDescription(
                "Organization changes everything in your life. How about making your routine more practical and stylish? Your custom pouch is just a click away. Let's get organized together?");
        enNecessaires.setCtaAttention(
                "⚡ ATTENTION: Due to high demand, our delivery time is 3-5 days. Secure yours now before the deadline increases!");
        enNecessaires.setCtaButtonText(
                "✨ YES! I Want My Custom Pouch");
        enNecessaires.setHeroTitle(
                "Pouches that Organize Your Life with Style");
        enNecessaires.setHeroButtonText(
                "💝 Create My Pouch");
        enNecessaires.setGaleriaTitle(
                "Each Pouch Tells Your Story");
        enNecessaires.setGaleriaDescricao(
                "See how we transform simple ideas into pouches that organize with love. Each detail is designed to make your routine easier and express who you are.");

// 4. Adicione as traduções à categoria e salve
        necessaires.getTranslations()
                .addAll(Arrays.asList(ptNecessaires, enNecessaires));
        categoriaRepository.save(necessaires);

        // Produtos para a categoria Necessaires
        // --- Produtos para a categoria Necessaires (CORRIGIDO) ---
// Produto 1
        Produto prodN1 = new Produto("/images/Produtos/Necessaires/Necessaire 6.jpg", necessaires);
        ProdutoTranslation ptProdN1 = new ProdutoTranslation();

        ptProdN1.setLocale(
                "pt-BR");
        ptProdN1.setProduto(prodN1);

        ptProdN1.setNome(
                "Para Heróis do Dia a Dia");
        ptProdN1.setDescricao(
                "Porque você quem cuida merece ser cuidado com o mesmo carinho. Uma homenagem à sua dedicação!");
        ProdutoTranslation enProdN1 = new ProdutoTranslation();

        enProdN1.setLocale(
                "en");
        enProdN1.setProduto(prodN1);

        enProdN1.setNome(
                "For Everyday Heroes");
        enProdN1.setDescricao(
                "Because those who care deserve to be cared for with the same affection. A tribute to your dedication!");
        prodN1.getTranslations()
                .addAll(Arrays.asList(ptProdN1, enProdN1));

// Produto 2
        Produto prodN2 = new Produto("/images/Produtos/Necessaires/Necessaire Cachorrinho.png", necessaires);
        ProdutoTranslation ptProdN2 = new ProdutoTranslation();

        ptProdN2.setLocale(
                "pt-BR");
        ptProdN2.setProduto(prodN2);

        ptProdN2.setNome(
                "Patinhas no Coração");
        ptProdN2.setDescricao(
                "Carregue seu melhor amigo para todo lugar! Personalize com a foto do seu pet ou escolha um desenho que represente esse amor incondicional.");
        ProdutoTranslation enProdN2 = new ProdutoTranslation();

        enProdN2.setLocale(
                "en");
        enProdN2.setProduto(prodN2);

        enProdN2.setNome(
                "Paws in Heart");
        enProdN2.setDescricao(
                "Carry your best friend everywhere! Customize with your pet's photo or choose a design that represents this unconditional love.");
        prodN2.getTranslations()
                .addAll(Arrays.asList(ptProdN2, enProdN2));

// Produto 3
        Produto prodN3 = new Produto("/images/Produtos/Necessaires/Necessaire Agatha.jpeg", necessaires);
        ProdutoTranslation ptProdN3 = new ProdutoTranslation();

        ptProdN3.setLocale(
                "pt-BR");
        ptProdN3.setProduto(prodN3);

        ptProdN3.setNome(
                "Kits Coordenados");
        ptProdN3.setDescricao(
                "Organize seu dia com elegância e seu próprio estilo. Cada peça é pensada para fazer parte da sua rotina de forma única e especial.");
        ProdutoTranslation enProdN3 = new ProdutoTranslation();

        enProdN3.setLocale(
                "en");
        enProdN3.setProduto(prodN3);

        enProdN3.setNome(
                "Coordinated Sets");
        enProdN3.setDescricao(
                "Organize your day with elegance and your own style. Each piece is designed to be part of your routine in a unique and special way.");
        prodN3.getTranslations()
                .addAll(Arrays.asList(ptProdN3, enProdN3));

// Produto 4
        Produto prodN4 = new Produto("/images/Produtos/Necessaires/Necessaire Religiosa.jpeg", necessaires);
        ProdutoTranslation ptProdN4 = new ProdutoTranslation();

        ptProdN4.setLocale(
                "pt-BR");
        ptProdN4.setProduto(prodN4);

        ptProdN4.setNome(
                "Fé que Acompanha");
        ptProdN4.setDescricao(
                "Sua devoção te acompanha em cada pequeno momento do dia. Um jeito especial de manter sua fé sempre pertinho, lembrando que você nunca está sozinho em sua jornada.");
        ProdutoTranslation enProdN4 = new ProdutoTranslation();

        enProdN4.setLocale(
                "en");
        enProdN4.setProduto(prodN4);

        enProdN4.setNome(
                "Faith that Accompanies");
        enProdN4.setDescricao(
                "Your devotion accompanies you in every small moment of the day. A special way to keep your faith always close, remembering that you are never alone on your journey.");
        prodN4.getTranslations()
                .addAll(Arrays.asList(ptProdN4, enProdN4));

// Produto 5
        Produto prodN5 = new Produto("/images/Produtos/Necessaires/960x640 Necessaire a paz esta dentro de voce.png", necessaires);
        ProdutoTranslation ptProdN5 = new ProdutoTranslation();

        ptProdN5.setLocale(
                "pt-BR");
        ptProdN5.setProduto(prodN5);

        ptProdN5.setNome(
                "Palavras que Abraçam");
        ptProdN5.setDescricao(
                "Um lembrete carinhoso de que você é mais forte do que imagina. Mensagens escolhidas com amor para te inspirar e te dar força nos momentos em que você mais precisa.");
        ProdutoTranslation enProdN5 = new ProdutoTranslation();

        enProdN5.setLocale(
                "en");
        enProdN5.setProduto(prodN5);

        enProdN5.setNome(
                "Words that Embrace");
        enProdN5.setDescricao(
                "A loving reminder that you are stronger than you imagine. Messages chosen with love to inspire you and give you strength in the moments you need it most.");
        prodN5.getTranslations()
                .addAll(Arrays.asList(ptProdN5, enProdN5));

// Produto 6
        Produto prodN6 = new Produto("/images/Produtos/Necessaires/Necessaire Estampa Tatiarte.jpeg", necessaires);
        ProdutoTranslation ptProdN6 = new ProdutoTranslation();

        ptProdN6.setLocale(
                "pt-BR");
        ptProdN6.setProduto(prodN6);

        ptProdN6.setNome(
                "Sua Imaginação é o Limite");
        ptProdN6.setDescricao(
                "Conte-nos sua ideia e vamos criar juntos a estampa perfeita para você. Seu estilo, sua personalidade, sua necessaire única!");
        ProdutoTranslation enProdN6 = new ProdutoTranslation();

        enProdN6.setLocale(
                "en");
        enProdN6.setProduto(prodN6);

        enProdN6.setNome(
                "Your Imagination is the Limit");
        enProdN6.setDescricao(
                "Tell us your idea and let's create together the perfect pattern for you. Your style, your personality, your unique pouch!");
        prodN6.getTranslations()
                .addAll(Arrays.asList(ptProdN6, enProdN6));
        produtoRepository.save(prodN1);

        produtoRepository.save(prodN2);

        produtoRepository.save(prodN3);

        produtoRepository.save(prodN4);

        produtoRepository.save(prodN5);

        produtoRepository.save(prodN6);

        // Depoimentos para a categoria Necessaires
        Depoimento depN1 = new Depoimento(
                "Tati Oliveira",
                "\"Gente, que necessaire LINDA! 😍 A Rita ficou emocionada com a personagem. Ficou exatamente como a foto que a Tati me mostrou! Achei incrível! 🥰\"",
                "/images/Produtos/Necessaires/Necessaire Rita 395x385 .png",
                necessaires
        );

        Depoimento depN2 = new Depoimento(
                "Ana Paula",
                "\"Me sinto abraçado por Jesus toda vez que uso 🙏✨ Tornou meus domingos ainda mais especiais!\". O acabamento é impecável e o material é super resistente! Amei demais! ❤️\"",
                "/images/Produtos/Necessaires/790x770 Necessaire Jesus.png",
                necessaires
        );

        Depoimento depN3 = new Depoimento(
                "Agatha Mendes",
                "\"Meu kit de necessaires chegou! Que organização PERFEITA! Cada tamanho para uma função. Recomendo muito! 🥰\"",
                "/images/Produtos/Necessaires/Necessaire Maria Maris.jpeg",
                necessaires
        );

        Depoimento depN4 = new Depoimento(
                "Luciana Consentino",
                "\"A necessaire que pedi ficou incrível! Dei te presente de dia das mães e ela amou! Disse que vai usar sempre, muito obrigada Tati!💕\"",
                "/images/Produtos/Necessaires/Necessaire Mae 395x385 .png",
                necessaires
        );

        Depoimento depN5 = new Depoimento(
                "Bruna Chanes",
                "\"Comprei uma necessaire para cada uma das minhas filhas! Cada uma com a estampa que elas escolheram. Agora cada uma tem seu cantinho organizado! 💕\"",
                "/images/Produtos/Necessaires/790x770 Necessaire Marilia e Thais.png",
                necessaires
        );

        Depoimento depN6 = new Depoimento(
                "Carla Medeiros",
                "\"Necessaire premium para executivas! Organização total para viagens de trabalho. Qualidade excepcional, recomendo para todas as profissionais!\"",
                "/images/Produtos/Necessaires/Necessaire Premium Aberta 395x385 .png",
                necessaires
        );

        depoimentoRepository.saveAll(Arrays.asList(depN1, depN2, depN3, depN4, depN5, depN6));

        // TIPOS DE PERSONALIZAÇÃO PARA A CATEGORIA 'NECESSAIRES'
        // 1. Cria o objeto principal sem o texto
        TipoPersonalizacao tipoNecessaire1 = new TipoPersonalizacao();

        tipoNecessaire1.setNomeIcone(
                "heart");
        tipoNecessaire1.setCategoria(necessaires);

// 2. Cria as traduções para o TÍTULO
        TipoPersonalizacaoTranslation ptTransN1 = new TipoPersonalizacaoTranslation();

        ptTransN1.setLocale(
                "pt-BR");
        ptTransN1.setTitulo(
                "Pets e Animais");
        ptTransN1.setTipoPersonalizacao(tipoNecessaire1);

        TipoPersonalizacaoTranslation enTransN1 = new TipoPersonalizacaoTranslation();

        enTransN1.setLocale(
                "en");
        enTransN1.setTitulo(
                "Pets & Animals");
        enTransN1.setTipoPersonalizacao(tipoNecessaire1);

// 3. Adiciona as traduções ao objeto principal
        tipoNecessaire1.getTranslations()
                .addAll(Arrays.asList(ptTransN1, enTransN1));

// 4. A criação dos ITENS continua igual por enquanto
        // --- Itens para "Pets e Animais" com tradução ---
// Item 1
        ItemPersonalizacao itemN1_1 = new ItemPersonalizacao();

        itemN1_1.setTipoPersonalizacao(tipoNecessaire1);
        ItemPersonalizacaoTranslation ptItemN1_1 = new ItemPersonalizacaoTranslation();

        ptItemN1_1.setLocale(
                "pt-BR");
        ptItemN1_1.setTexto(
                "Fotos dos seus pets favoritos");
        ptItemN1_1.setItemPersonalizacao(itemN1_1);
        ItemPersonalizacaoTranslation enItemN1_1 = new ItemPersonalizacaoTranslation();

        enItemN1_1.setLocale(
                "en");
        enItemN1_1.setTexto(
                "Photos of your favorite pets");
        enItemN1_1.setItemPersonalizacao(itemN1_1);

        itemN1_1.getTranslations()
                .addAll(Arrays.asList(ptItemN1_1, enItemN1_1));
        tipoNecessaire1.getItens()
                .add(itemN1_1);

// Item 2
        ItemPersonalizacao itemN1_2 = new ItemPersonalizacao();

        itemN1_2.setTipoPersonalizacao(tipoNecessaire1);
        ItemPersonalizacaoTranslation ptItemN1_2 = new ItemPersonalizacaoTranslation();

        ptItemN1_2.setLocale(
                "pt-BR");
        ptItemN1_2.setTexto(
                "Ilustrações personalizadas dos bichinhos");
        ptItemN1_2.setItemPersonalizacao(itemN1_2);
        ItemPersonalizacaoTranslation enItemN1_2 = new ItemPersonalizacaoTranslation();

        enItemN1_2.setLocale(
                "en");
        enItemN1_2.setTexto(
                "Custom illustrations of the critters");
        enItemN1_2.setItemPersonalizacao(itemN1_2);

        itemN1_2.getTranslations()
                .addAll(Arrays.asList(ptItemN1_2, enItemN1_2));
        tipoNecessaire1.getItens()
                .add(itemN1_2);

// Item 3
        ItemPersonalizacao itemN1_3 = new ItemPersonalizacao();

        itemN1_3.setTipoPersonalizacao(tipoNecessaire1);
        ItemPersonalizacaoTranslation ptItemN1_3 = new ItemPersonalizacaoTranslation();

        ptItemN1_3.setLocale(
                "pt-BR");
        ptItemN1_3.setTexto(
                "Nomes e datas especiais");
        ptItemN1_3.setItemPersonalizacao(itemN1_3);
        ItemPersonalizacaoTranslation enItemN1_3 = new ItemPersonalizacaoTranslation();

        enItemN1_3.setLocale(
                "en");
        enItemN1_3.setTexto(
                "Special names and dates");
        enItemN1_3.setItemPersonalizacao(itemN1_3);

        itemN1_3.getTranslations()
                .addAll(Arrays.asList(ptItemN1_3, enItemN1_3));
        tipoNecessaire1.getItens()
                .add(itemN1_3);

// Item 4
        ItemPersonalizacao itemN1_4 = new ItemPersonalizacao();

        itemN1_4.setTipoPersonalizacao(tipoNecessaire1);
        ItemPersonalizacaoTranslation ptItemN1_4 = new ItemPersonalizacaoTranslation();

        ptItemN1_4.setLocale(
                "pt-BR");
        ptItemN1_4.setTexto(
                "Patinhas e símbolos fofos");
        ptItemN1_4.setItemPersonalizacao(itemN1_4);
        ItemPersonalizacaoTranslation enItemN1_4 = new ItemPersonalizacaoTranslation();

        enItemN1_4.setLocale(
                "en");
        enItemN1_4.setTexto(
                "Cute paws and symbols");
        enItemN1_4.setItemPersonalizacao(itemN1_4);

        itemN1_4.getTranslations()
                .addAll(Arrays.asList(ptItemN1_4, enItemN1_4));
        tipoNecessaire1.getItens()
                .add(itemN1_4);

// Item 5
        ItemPersonalizacao itemN1_5 = new ItemPersonalizacao();

        itemN1_5.setTipoPersonalizacao(tipoNecessaire1);
        ItemPersonalizacaoTranslation ptItemN1_5 = new ItemPersonalizacaoTranslation();

        ptItemN1_5.setLocale(
                "pt-BR");
        ptItemN1_5.setTexto(
                "Raças específicas e características únicas");
        ptItemN1_5.setItemPersonalizacao(itemN1_5);
        ItemPersonalizacaoTranslation enItemN1_5 = new ItemPersonalizacaoTranslation();

        enItemN1_5.setLocale(
                "en");
        enItemN1_5.setTexto(
                "Specific breeds and unique features");
        enItemN1_5.setItemPersonalizacao(itemN1_5);

        itemN1_5.getTranslations()
                .addAll(Arrays.asList(ptItemN1_5, enItemN1_5));
        tipoNecessaire1.getItens()
                .add(itemN1_5);

        // --- TIPO 2: PROFISSÕES ESPECIAIS ---
        TipoPersonalizacao tipoNecessaire2 = new TipoPersonalizacao();

        tipoNecessaire2.setNomeIcone(
                "briefcase");
        tipoNecessaire2.setCategoria(necessaires);

        TipoPersonalizacaoTranslation ptTransN2 = new TipoPersonalizacaoTranslation();

        ptTransN2.setLocale(
                "pt-BR");
        ptTransN2.setTitulo(
                "Profissões Especiais");
        ptTransN2.setTipoPersonalizacao(tipoNecessaire2);

        TipoPersonalizacaoTranslation enTransN2 = new TipoPersonalizacaoTranslation();

        enTransN2.setLocale(
                "en");
        enTransN2.setTitulo(
                "Special Professions");
        enTransN2.setTipoPersonalizacao(tipoNecessaire2);

        tipoNecessaire2.getTranslations()
                .addAll(Arrays.asList(ptTransN2, enTransN2));

// Os itens da lista continuam iguais por enquanto
        // --- Itens para "Profissões Especiais" com tradução ---
// Item 1
        ItemPersonalizacao itemN2_1 = new ItemPersonalizacao();

        itemN2_1.setTipoPersonalizacao(tipoNecessaire2);
        ItemPersonalizacaoTranslation ptItemN2_1 = new ItemPersonalizacaoTranslation();

        ptItemN2_1.setLocale(
                "pt-BR");
        ptItemN2_1.setTexto(
                "Médicas, enfermeiras e profissionais da saúde");
        ptItemN2_1.setItemPersonalizacao(itemN2_1);
        ItemPersonalizacaoTranslation enItemN2_1 = new ItemPersonalizacaoTranslation();

        enItemN2_1.setLocale(
                "en");
        enItemN2_1.setTexto(
                "Doctors, nurses, and healthcare professionals");
        enItemN2_1.setItemPersonalizacao(itemN2_1);

        itemN2_1.getTranslations()
                .addAll(Arrays.asList(ptItemN2_1, enItemN2_1));
        tipoNecessaire2.getItens()
                .add(itemN2_1);

// Item 2
        ItemPersonalizacao itemN2_2 = new ItemPersonalizacao();

        itemN2_2.setTipoPersonalizacao(tipoNecessaire2);
        ItemPersonalizacaoTranslation ptItemN2_2 = new ItemPersonalizacaoTranslation();

        ptItemN2_2.setLocale(
                "pt-BR");
        ptItemN2_2.setTexto(
                "Professoras e educadoras");
        ptItemN2_2.setItemPersonalizacao(itemN2_2);
        ItemPersonalizacaoTranslation enItemN2_2 = new ItemPersonalizacaoTranslation();

        enItemN2_2.setLocale(
                "en");
        enItemN2_2.setTexto(
                "Teachers and educators");
        enItemN2_2.setItemPersonalizacao(itemN2_2);

        itemN2_2.getTranslations()
                .addAll(Arrays.asList(ptItemN2_2, enItemN2_2));
        tipoNecessaire2.getItens()
                .add(itemN2_2);

// Item 3
        ItemPersonalizacao itemN2_3 = new ItemPersonalizacao();

        itemN2_3.setTipoPersonalizacao(tipoNecessaire2);
        ItemPersonalizacaoTranslation ptItemN2_3 = new ItemPersonalizacaoTranslation();

        ptItemN2_3.setLocale(
                "pt-BR");
        ptItemN2_3.setTexto(
                "Advogadas e executivas");
        ptItemN2_3.setItemPersonalizacao(itemN2_3);
        ItemPersonalizacaoTranslation enItemN2_3 = new ItemPersonalizacaoTranslation();

        enItemN2_3.setLocale(
                "en");
        enItemN2_3.setTexto(
                "Lawyers and executives");
        enItemN2_3.setItemPersonalizacao(itemN2_3);

        itemN2_3.getTranslations()
                .addAll(Arrays.asList(ptItemN2_3, enItemN2_3));
        tipoNecessaire2.getItens()
                .add(itemN2_3);

// Item 4
        ItemPersonalizacao itemN2_4 = new ItemPersonalizacao();

        itemN2_4.setTipoPersonalizacao(tipoNecessaire2);
        ItemPersonalizacaoTranslation ptItemN2_4 = new ItemPersonalizacaoTranslation();

        ptItemN2_4.setLocale(
                "pt-BR");
        ptItemN2_4.setTexto(
                "Símbolos e ferramentas da profissão");
        ptItemN2_4.setItemPersonalizacao(itemN2_4);
        ItemPersonalizacaoTranslation enItemN2_4 = new ItemPersonalizacaoTranslation();

        enItemN2_4.setLocale(
                "en");
        enItemN2_4.setTexto(
                "Symbols and tools of the profession");
        enItemN2_4.setItemPersonalizacao(itemN2_4);

        itemN2_4.getTranslations()
                .addAll(Arrays.asList(ptItemN2_4, enItemN2_4));
        tipoNecessaire2.getItens()
                .add(itemN2_4);

// Item 5
        ItemPersonalizacao itemN2_5 = new ItemPersonalizacao();

        itemN2_5.setTipoPersonalizacao(tipoNecessaire2);
        ItemPersonalizacaoTranslation ptItemN2_5 = new ItemPersonalizacaoTranslation();

        ptItemN2_5.setLocale(
                "pt-BR");
        ptItemN2_5.setTexto(
                "Frases motivacionais da área");
        ptItemN2_5.setItemPersonalizacao(itemN2_5);
        ItemPersonalizacaoTranslation enItemN2_5 = new ItemPersonalizacaoTranslation();

        enItemN2_5.setLocale(
                "en");
        enItemN2_5.setTexto(
                "Motivational quotes from the field");
        enItemN2_5.setItemPersonalizacao(itemN2_5);

        itemN2_5.getTranslations()
                .addAll(Arrays.asList(ptItemN2_5, enItemN2_5));
        tipoNecessaire2.getItens()
                .add(itemN2_5);

// --- TIPO 3: FÉ E ESPIRITUALIDADE ---
        TipoPersonalizacao tipoNecessaire3 = new TipoPersonalizacao();

        tipoNecessaire3.setNomeIcone(
                "star");
        tipoNecessaire3.setCategoria(necessaires);

        TipoPersonalizacaoTranslation ptTransN3 = new TipoPersonalizacaoTranslation();

        ptTransN3.setLocale(
                "pt-BR");
        ptTransN3.setTitulo(
                "Fé e Espiritualidade");
        ptTransN3.setTipoPersonalizacao(tipoNecessaire3);

        TipoPersonalizacaoTranslation enTransN3 = new TipoPersonalizacaoTranslation();

        enTransN3.setLocale(
                "en");
        enTransN3.setTitulo(
                "Faith & Spirituality");
        enTransN3.setTipoPersonalizacao(tipoNecessaire3);

        tipoNecessaire3.getTranslations()
                .addAll(Arrays.asList(ptTransN3, enTransN3));

// Os itens da lista continuam iguais por enquanto
        // --- Itens para "Fé e Espiritualidade" com tradução ---
// Item 1
        ItemPersonalizacao itemN3_1 = new ItemPersonalizacao();

        itemN3_1.setTipoPersonalizacao(tipoNecessaire3);
        ItemPersonalizacaoTranslation ptItemN3_1 = new ItemPersonalizacaoTranslation();

        ptItemN3_1.setLocale(
                "pt-BR");
        ptItemN3_1.setTexto(
                "Nossa Senhora e santos de devoção");
        ptItemN3_1.setItemPersonalizacao(itemN3_1);
        ItemPersonalizacaoTranslation enItemN3_1 = new ItemPersonalizacaoTranslation();

        enItemN3_1.setLocale(
                "en");
        enItemN3_1.setTexto(
                "Our Lady and patron saints");
        enItemN3_1.setItemPersonalizacao(itemN3_1);

        itemN3_1.getTranslations()
                .addAll(Arrays.asList(ptItemN3_1, enItemN3_1));
        tipoNecessaire3.getItens()
                .add(itemN3_1);

// Item 2
        ItemPersonalizacao itemN3_2 = new ItemPersonalizacao();

        itemN3_2.setTipoPersonalizacao(tipoNecessaire3);
        ItemPersonalizacaoTranslation ptItemN3_2 = new ItemPersonalizacaoTranslation();

        ptItemN3_2.setLocale(
                "pt-BR");
        ptItemN3_2.setTexto(
                "Versículos bíblicos especiais");
        ptItemN3_2.setItemPersonalizacao(itemN3_2);
        ItemPersonalizacaoTranslation enItemN3_2 = new ItemPersonalizacaoTranslation();

        enItemN3_2.setLocale(
                "en");
        enItemN3_2.setTexto(
                "Special bible verses");
        enItemN3_2.setItemPersonalizacao(itemN3_2);

        itemN3_2.getTranslations()
                .addAll(Arrays.asList(ptItemN3_2, enItemN3_2));
        tipoNecessaire3.getItens()
                .add(itemN3_2);

// Item 3
        ItemPersonalizacao itemN3_3 = new ItemPersonalizacao();

        itemN3_3.setTipoPersonalizacao(tipoNecessaire3);
        ItemPersonalizacaoTranslation ptItemN3_3 = new ItemPersonalizacaoTranslation();

        ptItemN3_3.setLocale(
                "pt-BR");
        ptItemN3_3.setTexto(
                "Símbolos religiosos personalizados");
        ptItemN3_3.setItemPersonalizacao(itemN3_3);
        ItemPersonalizacaoTranslation enItemN3_3 = new ItemPersonalizacaoTranslation();

        enItemN3_3.setLocale(
                "en");
        enItemN3_3.setTexto(
                "Custom religious symbols");
        enItemN3_3.setItemPersonalizacao(itemN3_3);

        itemN3_3.getTranslations()
                .addAll(Arrays.asList(ptItemN3_3, enItemN3_3));
        tipoNecessaire3.getItens()
                .add(itemN3_3);

// Item 4
        ItemPersonalizacao itemN3_4 = new ItemPersonalizacao();

        itemN3_4.setTipoPersonalizacao(tipoNecessaire3);
        ItemPersonalizacaoTranslation ptItemN3_4 = new ItemPersonalizacaoTranslation();

        ptItemN3_4.setLocale(
                "pt-BR");
        ptItemN3_4.setTexto(
                "Orações e mensagens de fé");
        ptItemN3_4.setItemPersonalizacao(itemN3_4);
        ItemPersonalizacaoTranslation enItemN3_4 = new ItemPersonalizacaoTranslation();

        enItemN3_4.setLocale(
                "en");
        enItemN3_4.setTexto(
                "Prayers and messages of faith");
        enItemN3_4.setItemPersonalizacao(itemN3_4);

        itemN3_4.getTranslations()
                .addAll(Arrays.asList(ptItemN3_4, enItemN3_4));
        tipoNecessaire3.getItens()
                .add(itemN3_4);

// Item 5
        ItemPersonalizacao itemN3_5 = new ItemPersonalizacao();

        itemN3_5.setTipoPersonalizacao(tipoNecessaire3);
        ItemPersonalizacaoTranslation ptItemN3_5 = new ItemPersonalizacaoTranslation();

        ptItemN3_5.setLocale(
                "pt-BR");
        ptItemN3_5.setTexto(
                "Anjos e elementos celestiais");
        ptItemN3_5.setItemPersonalizacao(itemN3_5);
        ItemPersonalizacaoTranslation enItemN3_5 = new ItemPersonalizacaoTranslation();

        enItemN3_5.setLocale(
                "en");
        enItemN3_5.setTexto(
                "Angels and celestial elements");
        enItemN3_5.setItemPersonalizacao(itemN3_5);

        itemN3_5.getTranslations()
                .addAll(Arrays.asList(ptItemN3_5, enItemN3_5));
        tipoNecessaire3.getItens()
                .add(itemN3_5);

        // --- TIPO 4: ANIME E PERSONAGENS ---
        TipoPersonalizacao tipoNecessaire4 = new TipoPersonalizacao();

        tipoNecessaire4.setNomeIcone(
                "gamepad-2");
        tipoNecessaire4.setCategoria(necessaires);

        TipoPersonalizacaoTranslation ptTransN4 = new TipoPersonalizacaoTranslation();

        ptTransN4.setLocale(
                "pt-BR");
        ptTransN4.setTitulo(
                "Anime e Personagens");
        ptTransN4.setTipoPersonalizacao(tipoNecessaire4);

        TipoPersonalizacaoTranslation enTransN4 = new TipoPersonalizacaoTranslation();

        enTransN4.setLocale(
                "en");
        enTransN4.setTitulo(
                "Anime & Characters");
        enTransN4.setTipoPersonalizacao(tipoNecessaire4);

        tipoNecessaire4.getTranslations()
                .addAll(Arrays.asList(ptTransN4, enTransN4));

// Os itens da lista continuam iguais por enquanto
        // --- Itens para "Anime e Personagens" com tradução ---
// Item 1
        ItemPersonalizacao itemN4_1 = new ItemPersonalizacao();

        itemN4_1.setTipoPersonalizacao(tipoNecessaire4);
        ItemPersonalizacaoTranslation ptItemN4_1 = new ItemPersonalizacaoTranslation();

        ptItemN4_1.setLocale(
                "pt-BR");
        ptItemN4_1.setTexto(
                "Personagens de anime favoritos");
        ptItemN4_1.setItemPersonalizacao(itemN4_1);
        ItemPersonalizacaoTranslation enItemN4_1 = new ItemPersonalizacaoTranslation();

        enItemN4_1.setLocale(
                "en");
        enItemN4_1.setTexto(
                "Favorite anime characters");
        enItemN4_1.setItemPersonalizacao(itemN4_1);

        itemN4_1.getTranslations()
                .addAll(Arrays.asList(ptItemN4_1, enItemN4_1));
        tipoNecessaire4.getItens()
                .add(itemN4_1);

// Item 2
        ItemPersonalizacao itemN4_2 = new ItemPersonalizacao();

        itemN4_2.setTipoPersonalizacao(tipoNecessaire4);
        ItemPersonalizacaoTranslation ptItemN4_2 = new ItemPersonalizacaoTranslation();

        ptItemN4_2.setLocale(
                "pt-BR");
        ptItemN4_2.setTexto(
                "Desenhos animados clássicos");
        ptItemN4_2.setItemPersonalizacao(itemN4_2);
        ItemPersonalizacaoTranslation enItemN4_2 = new ItemPersonalizacaoTranslation();

        enItemN4_2.setLocale(
                "en");
        enItemN4_2.setTexto(
                "Classic cartoon characters");
        enItemN4_2.setItemPersonalizacao(itemN4_2);

        itemN4_2.getTranslations()
                .addAll(Arrays.asList(ptItemN4_2, enItemN4_2));
        tipoNecessaire4.getItens()
                .add(itemN4_2);

// Item 3
        ItemPersonalizacao itemN4_3 = new ItemPersonalizacao();

        itemN4_3.setTipoPersonalizacao(tipoNecessaire4);
        ItemPersonalizacaoTranslation ptItemN4_3 = new ItemPersonalizacaoTranslation();

        ptItemN4_3.setLocale(
                "pt-BR");
        ptItemN4_3.setTexto(
                "Filmes e séries que você ama");
        ptItemN4_3.setItemPersonalizacao(itemN4_3);
        ItemPersonalizacaoTranslation enItemN4_3 = new ItemPersonalizacaoTranslation();

        enItemN4_3.setLocale(
                "en");
        enItemN4_3.setTexto(
                "Movies and series you love");
        enItemN4_3.setItemPersonalizacao(itemN4_3);

        itemN4_3.getTranslations()
                .addAll(Arrays.asList(ptItemN4_3, enItemN4_3));
        tipoNecessaire4.getItens()
                .add(itemN4_3);

// Item 4
        ItemPersonalizacao itemN4_4 = new ItemPersonalizacao();

        itemN4_4.setTipoPersonalizacao(tipoNecessaire4);
        ItemPersonalizacaoTranslation ptItemN4_4 = new ItemPersonalizacaoTranslation();

        ptItemN4_4.setLocale(
                "pt-BR");
        ptItemN4_4.setTexto(
                "Logos e símbolos icônicos");
        ptItemN4_4.setItemPersonalizacao(itemN4_4);
        ItemPersonalizacaoTranslation enItemN4_4 = new ItemPersonalizacaoTranslation();

        enItemN4_4.setLocale(
                "en");
        enItemN4_4.setTexto(
                "Iconic logos and symbols");
        enItemN4_4.setItemPersonalizacao(itemN4_4);

        itemN4_4.getTranslations()
                .addAll(Arrays.asList(ptItemN4_4, enItemN4_4));
        tipoNecessaire4.getItens()
                .add(itemN4_4);

// Item 5
        ItemPersonalizacao itemN4_5 = new ItemPersonalizacao();

        itemN4_5.setTipoPersonalizacao(tipoNecessaire4);
        ItemPersonalizacaoTranslation ptItemN4_5 = new ItemPersonalizacaoTranslation();

        ptItemN4_5.setLocale(
                "pt-BR");
        ptItemN4_5.setTexto(
                "Frases marcantes dos personagens");
        ptItemN4_5.setItemPersonalizacao(itemN4_5);
        ItemPersonalizacaoTranslation enItemN4_5 = new ItemPersonalizacaoTranslation();

        enItemN4_5.setLocale(
                "en");
        enItemN4_5.setTexto(
                "Memorable character quotes");
        enItemN4_5.setItemPersonalizacao(itemN4_5);

        itemN4_5.getTranslations()
                .addAll(Arrays.asList(ptItemN4_5, enItemN4_5));
        tipoNecessaire4.getItens()
                .add(itemN4_5);

// --- TIPO 5: NOMES E MONOGRAMAS ---
        TipoPersonalizacao tipoNecessaire5 = new TipoPersonalizacao();

        tipoNecessaire5.setNomeIcone(
                "palette");
        tipoNecessaire5.setCategoria(necessaires);

        TipoPersonalizacaoTranslation ptTransN5 = new TipoPersonalizacaoTranslation();

        ptTransN5.setLocale(
                "pt-BR");
        ptTransN5.setTitulo(
                "Nomes e Monogramas");
        ptTransN5.setTipoPersonalizacao(tipoNecessaire5);

        TipoPersonalizacaoTranslation enTransN5 = new TipoPersonalizacaoTranslation();

        enTransN5.setLocale(
                "en");
        enTransN5.setTitulo(
                "Names & Monograms");
        enTransN5.setTipoPersonalizacao(tipoNecessaire5);

        tipoNecessaire5.getTranslations()
                .addAll(Arrays.asList(ptTransN5, enTransN5));

// Os itens da lista continuam iguais por enquanto
        // --- Itens para "Nomes e Monogramas" com tradução ---
// Item 1
        ItemPersonalizacao itemN5_1 = new ItemPersonalizacao();

        itemN5_1.setTipoPersonalizacao(tipoNecessaire5);
        ItemPersonalizacaoTranslation ptItemN5_1 = new ItemPersonalizacaoTranslation();

        ptItemN5_1.setLocale(
                "pt-BR");
        ptItemN5_1.setTexto(
                "Seu nome em tipografias exclusivas");
        ptItemN5_1.setItemPersonalizacao(itemN5_1);
        ItemPersonalizacaoTranslation enItemN5_1 = new ItemPersonalizacaoTranslation();

        enItemN5_1.setLocale(
                "en");
        enItemN5_1.setTexto(
                "Your name in exclusive fonts");
        enItemN5_1.setItemPersonalizacao(itemN5_1);

        itemN5_1.getTranslations()
                .addAll(Arrays.asList(ptItemN5_1, enItemN5_1));
        tipoNecessaire5.getItens()
                .add(itemN5_1);

// Item 2
        ItemPersonalizacao itemN5_2 = new ItemPersonalizacao();

        itemN5_2.setTipoPersonalizacao(tipoNecessaire5);
        ItemPersonalizacaoTranslation ptItemN5_2 = new ItemPersonalizacaoTranslation();

        ptItemN5_2.setLocale(
                "pt-BR");
        ptItemN5_2.setTexto(
                "Monogramas elegantes e sofisticados");
        ptItemN5_2.setItemPersonalizacao(itemN5_2);
        ItemPersonalizacaoTranslation enItemN5_2 = new ItemPersonalizacaoTranslation();

        enItemN5_2.setLocale(
                "en");
        enItemN5_2.setTexto(
                "Elegant and sophisticated monograms");
        enItemN5_2.setItemPersonalizacao(itemN5_2);

        itemN5_2.getTranslations()
                .addAll(Arrays.asList(ptItemN5_2, enItemN5_2));
        tipoNecessaire5.getItens()
                .add(itemN5_2);

// Item 3
        ItemPersonalizacao itemN5_3 = new ItemPersonalizacao();

        itemN5_3.setTipoPersonalizacao(tipoNecessaire5);
        ItemPersonalizacaoTranslation ptItemN5_3 = new ItemPersonalizacaoTranslation();

        ptItemN5_3.setLocale(
                "pt-BR");
        ptItemN5_3.setTexto(
                "Iniciais decorativas");
        ptItemN5_3.setItemPersonalizacao(itemN5_3);
        ItemPersonalizacaoTranslation enItemN5_3 = new ItemPersonalizacaoTranslation();

        enItemN5_3.setLocale(
                "en");
        enItemN5_3.setTexto(
                "Decorative initials");
        enItemN5_3.setItemPersonalizacao(itemN5_3);

        itemN5_3.getTranslations()
                .addAll(Arrays.asList(ptItemN5_3, enItemN5_3));
        tipoNecessaire5.getItens()
                .add(itemN5_3);

// Item 4
        ItemPersonalizacao itemN5_4 = new ItemPersonalizacao();

        itemN5_4.setTipoPersonalizacao(tipoNecessaire5);
        ItemPersonalizacaoTranslation ptItemN5_4 = new ItemPersonalizacaoTranslation();

        ptItemN5_4.setLocale(
                "pt-BR");
        ptItemN5_4.setTexto(
                "Combinações de nomes especiais");
        ptItemN5_4.setItemPersonalizacao(itemN5_4);
        ItemPersonalizacaoTranslation enItemN5_4 = new ItemPersonalizacaoTranslation();

        enItemN5_4.setLocale(
                "en");
        enItemN5_4.setTexto(
                "Special name combinations");
        enItemN5_4.setItemPersonalizacao(itemN5_4);

        itemN5_4.getTranslations()
                .addAll(Arrays.asList(ptItemN5_4, enItemN5_4));
        tipoNecessaire5.getItens()
                .add(itemN5_4);

// Item 5
        ItemPersonalizacao itemN5_5 = new ItemPersonalizacao();

        itemN5_5.setTipoPersonalizacao(tipoNecessaire5);
        ItemPersonalizacaoTranslation ptItemN5_5 = new ItemPersonalizacaoTranslation();

        ptItemN5_5.setLocale(
                "pt-BR");
        ptItemN5_5.setTexto(
                "Assinaturas personalizadas");
        ptItemN5_5.setItemPersonalizacao(itemN5_5);
        ItemPersonalizacaoTranslation enItemN5_5 = new ItemPersonalizacaoTranslation();

        enItemN5_5.setLocale(
                "en");
        enItemN5_5.setTexto(
                "Custom signatures");
        enItemN5_5.setItemPersonalizacao(itemN5_5);

        itemN5_5.getTranslations()
                .addAll(Arrays.asList(ptItemN5_5, enItemN5_5));
        tipoNecessaire5.getItens()
                .add(itemN5_5);

// --- TIPO 6: ESTAMPAS EXCLUSIVAS ---
        TipoPersonalizacao tipoNecessaire6 = new TipoPersonalizacao();

        tipoNecessaire6.setNomeIcone(
                "sparkles");
        tipoNecessaire6.setCategoria(necessaires);

        TipoPersonalizacaoTranslation ptTransN6 = new TipoPersonalizacaoTranslation();

        ptTransN6.setLocale(
                "pt-BR");
        ptTransN6.setTitulo(
                "Estampas Exclusivas");
        ptTransN6.setTipoPersonalizacao(tipoNecessaire6);

        TipoPersonalizacaoTranslation enTransN6 = new TipoPersonalizacaoTranslation();

        enTransN6.setLocale(
                "en");
        enTransN6.setTitulo(
                "Exclusive Prints");
        enTransN6.setTipoPersonalizacao(tipoNecessaire6);

        tipoNecessaire6.getTranslations()
                .addAll(Arrays.asList(ptTransN6, enTransN6));

// Os itens da lista continuam iguais por enquanto
        // --- Itens para "Estampas Exclusivas" com tradução ---
// Item 1
        ItemPersonalizacao itemN6_1 = new ItemPersonalizacao();

        itemN6_1.setTipoPersonalizacao(tipoNecessaire6);
        ItemPersonalizacaoTranslation ptItemN6_1 = new ItemPersonalizacaoTranslation();

        ptItemN6_1.setLocale(
                "pt-BR");
        ptItemN6_1.setTexto(
                "Florais delicados e modernos");
        ptItemN6_1.setItemPersonalizacao(itemN6_1);
        ItemPersonalizacaoTranslation enItemN6_1 = new ItemPersonalizacaoTranslation();

        enItemN6_1.setLocale(
                "en");
        enItemN6_1.setTexto(
                "Delicate and modern florals");
        enItemN6_1.setItemPersonalizacao(itemN6_1);

        itemN6_1.getTranslations()
                .addAll(Arrays.asList(ptItemN6_1, enItemN6_1));
        tipoNecessaire6.getItens()
                .add(itemN6_1);

// Item 2
        ItemPersonalizacao itemN6_2 = new ItemPersonalizacao();

        itemN6_2.setTipoPersonalizacao(tipoNecessaire6);
        ItemPersonalizacaoTranslation ptItemN6_2 = new ItemPersonalizacaoTranslation();

        ptItemN6_2.setLocale(
                "pt-BR");
        ptItemN6_2.setTexto(
                "Padrões geométricos únicos");
        ptItemN6_2.setItemPersonalizacao(itemN6_2);
        ItemPersonalizacaoTranslation enItemN6_2 = new ItemPersonalizacaoTranslation();

        enItemN6_2.setLocale(
                "en");
        enItemN6_2.setTexto(
                "Unique geometric patterns");
        enItemN6_2.setItemPersonalizacao(itemN6_2);

        itemN6_2.getTranslations()
                .addAll(Arrays.asList(ptItemN6_2, enItemN6_2));
        tipoNecessaire6.getItens()
                .add(itemN6_2);

// Item 3
        ItemPersonalizacao itemN6_3 = new ItemPersonalizacao();

        itemN6_3.setTipoPersonalizacao(tipoNecessaire6);
        ItemPersonalizacaoTranslation ptItemN6_3 = new ItemPersonalizacaoTranslation();

        ptItemN6_3.setLocale(
                "pt-BR");
        ptItemN6_3.setTexto(
                "Aquarelas e arte abstrata");
        ptItemN6_3.setItemPersonalizacao(itemN6_3);
        ItemPersonalizacaoTranslation enItemN6_3 = new ItemPersonalizacaoTranslation();

        enItemN6_3.setLocale(
                "en");
        enItemN6_3.setTexto(
                "Watercolors and abstract art");
        enItemN6_3.setItemPersonalizacao(itemN6_3);

        itemN6_3.getTranslations()
                .addAll(Arrays.asList(ptItemN6_3, enItemN6_3));
        tipoNecessaire6.getItens()
                .add(itemN6_3);

// Item 4
        ItemPersonalizacao itemN6_4 = new ItemPersonalizacao();

        itemN6_4.setTipoPersonalizacao(tipoNecessaire6);
        ItemPersonalizacaoTranslation ptItemN6_4 = new ItemPersonalizacaoTranslation();

        ptItemN6_4.setLocale(
                "pt-BR");
        ptItemN6_4.setTexto(
                "Combinações de cores favoritas");
        ptItemN6_4.setItemPersonalizacao(itemN6_4);
        ItemPersonalizacaoTranslation enItemN6_4 = new ItemPersonalizacaoTranslation();

        enItemN6_4.setLocale(
                "en");
        enItemN6_4.setTexto(
                "Favorite color combinations");
        enItemN6_4.setItemPersonalizacao(itemN6_4);

        itemN6_4.getTranslations()
                .addAll(Arrays.asList(ptItemN6_4, enItemN6_4));
        tipoNecessaire6.getItens()
                .add(itemN6_4);

// Item 5
        ItemPersonalizacao itemN6_5 = new ItemPersonalizacao();

        itemN6_5.setTipoPersonalizacao(tipoNecessaire6);
        ItemPersonalizacaoTranslation ptItemN6_5 = new ItemPersonalizacaoTranslation();

        ptItemN6_5.setLocale(
                "pt-BR");
        ptItemN6_5.setTexto(
                "Texturas e efeitos especiais");
        ptItemN6_5.setItemPersonalizacao(itemN6_5);
        ItemPersonalizacaoTranslation enItemN6_5 = new ItemPersonalizacaoTranslation();

        enItemN6_5.setLocale(
                "en");
        enItemN6_5.setTexto(
                "Special textures and effects");
        enItemN6_5.setItemPersonalizacao(itemN6_5);

        itemN6_5.getTranslations()
                .addAll(Arrays.asList(ptItemN6_5, enItemN6_5));
        tipoNecessaire6.getItens()
                .add(itemN6_5);

// --- SALVA TODOS OS TIPOS DE UMA VEZ ---
        tipoPersonalizacaoRepository.saveAll(Arrays.asList(tipoNecessaire1, tipoNecessaire2, tipoNecessaire3, tipoNecessaire4, tipoNecessaire5, tipoNecessaire6));

    }

    private void criarCategoriaCanecas() {
        // --- CATEGORIA CANECAS ---
        // --- CATEGORIA CANECAS ---
        Categoria canecas = new Categoria();
// 1. Defina os campos que NÃO são traduzidos

        canecas.setSlug(
                "canecas");
        canecas.setImagemDestaqueUrl(
                "/images/Produtos/Caneca/Caneca Frases de mae.jpg");
        canecas.setUrlImagemPersonalizacao(
                "/images/Produtos/Caneca/Caneca 1.jpg");
        canecas.setImagemUrlHome(
                "/images/Home/960x640 Caneca Espresso Patronum.png");

// 2. Crie a tradução para Português (pt-BR)
        CategoriaTranslation ptCanecas = new CategoriaTranslation();

        ptCanecas.setLocale(
                "pt-BR");
        ptCanecas.setCategoria(canecas);

        ptCanecas.setNomeSingular(
                "Caneca");
        ptCanecas.setNomePlural(
                "Canecas Personalizadas");
        ptCanecas.setDescricao(
                "Transforme momentos especiais em lembranças eternas. Cada caneca é 100% personalizada e feita com amor para emocionar quem você ama.");
        ptCanecas.setCtaTitle(
                "Não Deixe Esse Momento Passar...");
        ptCanecas.setCtaDescription(
                "A vida é feita de momentos únicos. Que tal transformar o próximo em uma lembrança eterna? Sua caneca personalizada está a apenas um clique de distância. Vamos criar magia juntos?");
        ptCanecas.setCtaAttention(
                "⚡ ATENÇÃO: Devido à alta demanda, estamos com prazo de entrega de 3-5 dias. Garante já a sua antes que o prazo aumente!");
        ptCanecas.setCtaButtonText(
                "✨ SIM! Quero Minha Caneca Personalizada");
        ptCanecas.setHeroTitle(
                "Canecas que Deixam Manhãs Mais Especiais");
        ptCanecas.setHeroButtonText(
                "💝 Criar Minha Caneca");
        ptCanecas.setGaleriaTitle(
                "Cada Caneca Tem Seu Significado Único");
                ptCanecas.setGaleriaDescricao(
                        "Transforme o café da manhã em algo especial com nossas canecas personalizadas. Cada detalhe é pensado para expressar quem você é, e refletir um momento especial.");

// 3. Crie a tradução para Inglês (en)
        CategoriaTranslation enCanecas = new CategoriaTranslation();

        enCanecas.setLocale(
                "en");
        enCanecas.setCategoria(canecas);

        enCanecas.setNomeSingular(
                "Mug");
        enCanecas.setNomePlural(
                "Custom Mugs");
        enCanecas.setDescricao(
                "Turn special moments into eternal memories. Each mug is 100% personalized and made with love to touch the hearts of those you love.");
        enCanecas.setCtaTitle(
                "Don't Let This Moment Pass...");
        enCanecas.setCtaDescription(
                "Life is made of unique moments. How about turning the next one into an eternal memory? Your custom mug is just a click away. Let's create magic together?");
        enCanecas.setCtaAttention(
                "⚡ ATTENTION: Due to high demand, our delivery time is 3-5 days. Secure yours now before the deadline increases!");
        enCanecas.setCtaButtonText(
                "✨ YES! I Want My Custom Mug");
        enCanecas.setHeroTitle(
                "Mugs that Tell Unique Stories");
        enCanecas.setHeroButtonText(
                "💝 Create My Mug");
        enCanecas.setGaleriaTitle(
                "Each Mug Has a Special Meaning");
        enCanecas.setGaleriaDescricao(
                "Transform the morning coffee into something special with our personalized mugs. Each detail is designed to express who you are and reflect a special moment.");

// 4. Adicione as traduções à categoria e salve
        canecas.getTranslations()
                .addAll(Arrays.asList(ptCanecas, enCanecas));
        categoriaRepository.save(canecas);

        // --- Produtos para a categoria Canecas (CORRIGIDO) ---
// Produto 1
        Produto c1 = new Produto("/images/Produtos/Caneca/960x640 Caneca Mae Coracao Quentinho.png", canecas);
        ProdutoTranslation ptC1 = new ProdutoTranslation();

        ptC1.setLocale(
                "pt-BR");
        ptC1.setNome(
                "Aquele Cafézinho com Amor de Mãe");
        ptC1.setDescricao(
                "Porque nada é mais acolhedor que um café quentinho com a mamãe");
        ptC1.setProduto(c1);
        ProdutoTranslation enC1 = new ProdutoTranslation();

        enC1.setLocale(
                "en");
        enC1.setNome(
                "That Coffee with Mother's Love");
        enC1.setDescricao(
                "Because nothing is more comforting than a warm coffee with mom");
        enC1.setProduto(c1);

        c1.getTranslations()
                .addAll(Arrays.asList(ptC1, enC1));
        produtoRepository.save(c1);

// Produto 2
        Produto c2 = new Produto("/images/Produtos/Caneca/960x640 Caneca Espresso Patronum.png", canecas);
        ProdutoTranslation ptC2 = new ProdutoTranslation();

        ptC2.setLocale(
                "pt-BR");
        ptC2.setNome(
                "Para Fãs de Histórias Mágicas");
        ptC2.setDescricao(
                "Transforme seu café em pura magia com nossas canecas inspiradas em filmes ou séries");
        ptC2.setProduto(c2);
        ProdutoTranslation enC2 = new ProdutoTranslation();

        enC2.setLocale(
                "en");
        enC2.setNome(
                "For Magical Stories Fans");
        enC2.setDescricao(
                "Transform your coffee into pure magic with our mugs inspired by movies or series");
        enC2.setProduto(c2);

        c2.getTranslations()
                .addAll(Arrays.asList(ptC2, enC2));
        produtoRepository.save(c2);

// Produto 3
        Produto c3 = new Produto("/images/Produtos/Caneca/960x640 kit Caneca Mae Avo.png", canecas);
        ProdutoTranslation ptC3 = new ProdutoTranslation();

        ptC3.setLocale(
                "pt-BR");
        ptC3.setNome(
                "Kits que Contam Histórias de Família");
        ptC3.setDescricao(
                "Celebre o amor que passa de geração em geração com nossas canecas personalizadas");
        ptC3.setProduto(c3);
        ProdutoTranslation enC3 = new ProdutoTranslation();

        enC3.setLocale(
                "en");
        enC3.setNome(
                "Kits that Tell Family Stories");
        enC3.setDescricao(
                "Celebrate the love that passes from generation to generation with our custom mugs");
        enC3.setProduto(c3);

        c3.getTranslations()
                .addAll(Arrays.asList(ptC3, enC3));
        produtoRepository.save(c3);

// Produto 4
        Produto c4 = new Produto("/images/Produtos/Caneca/960x640 Caneca Frase Inspiradora.png", canecas);
        ProdutoTranslation ptC4 = new ProdutoTranslation();

        ptC4.setLocale(
                "pt-BR");
        ptC4.setNome(
                "Mensagens que Florescem no Coração");
        ptC4.setDescricao(
                "Palavras delicadas que transformam sua manhã em algo especial");
        ptC4.setProduto(c4);
        ProdutoTranslation enC4 = new ProdutoTranslation();

        enC4.setLocale(
                "en");
        enC4.setNome(
                "Messages that Bloom in the Heart");
        enC4.setDescricao(
                "Delicate words that transform your morning into something special");
        enC4.setProduto(c4);

        c4.getTranslations()
                .addAll(Arrays.asList(ptC4, enC4));
        produtoRepository.save(c4);

// Produto 5
        Produto c5 = new Produto("/images/Produtos/Caneca/960X640 Caneca Cerveja Rafael.png", canecas);
        ProdutoTranslation ptC5 = new ProdutoTranslation();

        ptC5.setLocale(
                "pt-BR");
        ptC5.setNome(
                "Suas Sextas Mais Especiais");
        ptC5.setDescricao(
                "Aquela caneca personalizada que vai fazer seu happy hour único! Seu nome, seu momento!");
        ptC5.setProduto(c5);
        ProdutoTranslation enC5 = new ProdutoTranslation();

        enC5.setLocale(
                "en");
        enC5.setNome(
                "Your Most Special Fridays");
        enC5.setDescricao(
                "That custom mug that will make your happy hour unique! Your name, your moment!");
        enC5.setProduto(c5);

        c5.getTranslations()
                .addAll(Arrays.asList(ptC5, enC5));
        produtoRepository.save(c5);

// Produto 6
        Produto c6 = new Produto("/images/Produtos/Caneca/960x640 Caneca Amor.png", canecas);
        ProdutoTranslation ptC6 = new ProdutoTranslation();

        ptC6.setLocale(
                "pt-BR");
        ptC6.setNome(
                "Laços de Amor em Cada Café");
        ptC6.setDescricao(
                "Celebre os pequenos gestos de carinho no dia a dia! Perfeito para compartilhar momentos especiais e fortalecer laços com quem você ama.");
        ptC6.setProduto(c6);
        ProdutoTranslation enC6 = new ProdutoTranslation();

        enC6.setLocale(
                "en");
        enC6.setNome(
                "Love Loops in Every Cup");
        enC6.setDescricao(
                "Celebrate the little gestures of love every day! Perfect for sharing special moments and strengthening bonds with those you love.");
        enC6.setProduto(c6);

        c6.getTranslations()
                .addAll(Arrays.asList(ptC6, enC6));
        produtoRepository.save(c6);

        // Depoimentos para a categoria Canecas
        Depoimento dc1 = new Depoimento("Maria Santos",
                "\"Gente, olha que PERFEITA ficou a caneca da minha mãe! Ela chorou quando viu. Muito obrigada, ficou exatamente como eu imaginei!\"",
                "/images/Produtos/Caneca/790x770 Caneca Mae Flor que Floresce.png",
                canecas);

        Depoimento dc2 = new Depoimento("Ana Clara",
                "\"Meu sogro AMOU essa caneca! Disse que finalmente alguém entende ele 😂 Qualidade incrível!\"",
                "/images/Produtos/Caneca/790x770 Caneca Copao Cerveja.png",
                canecas);

        Depoimento dc3 = new Depoimento("Juliana Madalena",
                "\"Finalmente uma caneca que representa nós, mães de pets! Minha bebê aparece até na foto fazendo pose. Amei demais! 🐾\"",
                "/images/Produtos/Caneca/790x770 Caneca Mae de Pet.png",
                canecas);

        Depoimento dc4 = new Depoimento("Carla Mendes",
                "\"O kit ficou LINDO! A embalagem, o cuidado com cada detalhe... Minha mãe se emocionou muito ❤️\"",
                "/images/Produtos/Caneca/790x770 Caneca kit presente 90 anos.png",
                canecas);

        Depoimento dc5 = new Depoimento("Roberta Lima",
                "\"Gente, que caneca linda! 100% personalizada pro meu filho, exatamente como eu pedi pra Tati. Recomendo demais! 🥰\"",
                "/images/Produtos/Caneca/790x770 Caneca Engenharia por Amor.png",
                canecas);

        Depoimento dc6 = new Depoimento("Empresa TechCorp",
                "\"A qualidade dessa torre de canecas é incrivel e ainda são perfeitas pra decorar meu cantinho do café. Todo mundo que vem em casa elogia! 💝\"",
                "/images/Produtos/Caneca/790x770 Caneca Torre de Canecas.png",
                canecas);

        depoimentoRepository.saveAll(Arrays.asList(dc1, dc2, dc3, dc4, dc5, dc6));

        // --- TIPOS DE PERSONALIZAÇÃO PARA A CATEGORIA 'CANECAS' (CORRIGIDO) ---
        TipoPersonalizacao tipoCaneca1 = new TipoPersonalizacao();

        tipoCaneca1.setNomeIcone(
                "heart");
        tipoCaneca1.setCategoria(canecas);
        TipoPersonalizacaoTranslation ptTransC1 = new TipoPersonalizacaoTranslation();

        ptTransC1.setLocale(
                "pt-BR");
        ptTransC1.setTitulo(
                "Para Mães e Avós");
        ptTransC1.setTipoPersonalizacao(tipoCaneca1);
        TipoPersonalizacaoTranslation enTransC1 = new TipoPersonalizacaoTranslation();

        enTransC1.setLocale(
                "en");
        enTransC1.setTitulo(
                "For Moms & Grandmas");
        enTransC1.setTipoPersonalizacao(tipoCaneca1);

        tipoCaneca1.getTranslations()
                .addAll(Arrays.asList(ptTransC1, enTransC1));
// Itens continuam iguais por enquanto
        // --- Itens para "Para Mães e Avós" com tradução ---

// Item 1
        ItemPersonalizacao itemC1_1 = new ItemPersonalizacao();

        itemC1_1.setTipoPersonalizacao(tipoCaneca1);
        ItemPersonalizacaoTranslation ptItemC1_1 = new ItemPersonalizacaoTranslation();

        ptItemC1_1.setLocale(
                "pt-BR");
        ptItemC1_1.setTexto(
                "Datas especiais (nascimento dos filhos/netos)");
        ptItemC1_1.setItemPersonalizacao(itemC1_1);
        ItemPersonalizacaoTranslation enItemC1_1 = new ItemPersonalizacaoTranslation();

        enItemC1_1.setLocale(
                "en");
        enItemC1_1.setTexto(
                "Special dates (birth of children/grandchildren)");
        enItemC1_1.setItemPersonalizacao(itemC1_1);

        itemC1_1.getTranslations()
                .addAll(Arrays.asList(ptItemC1_1, enItemC1_1));
        tipoCaneca1.getItens()
                .add(itemC1_1);

// Item 2
        ItemPersonalizacao itemC1_2 = new ItemPersonalizacao();

        itemC1_2.setTipoPersonalizacao(tipoCaneca1);
        ItemPersonalizacaoTranslation ptItemC1_2 = new ItemPersonalizacaoTranslation();

        ptItemC1_2.setLocale(
                "pt-BR");
        ptItemC1_2.setTexto(
                "Frases marcantes que toda mãe fala");
        ptItemC1_2.setItemPersonalizacao(itemC1_2);
        ItemPersonalizacaoTranslation enItemC1_2 = new ItemPersonalizacaoTranslation();

        enItemC1_2.setLocale(
                "en");
        enItemC1_2.setTexto(
                "Catchphrases every mom says");
        enItemC1_2.setItemPersonalizacao(itemC1_2);

        itemC1_2.getTranslations()
                .addAll(Arrays.asList(ptItemC1_2, enItemC1_2));
        tipoCaneca1.getItens()
                .add(itemC1_2);

// Item 3
        ItemPersonalizacao itemC1_3 = new ItemPersonalizacao();

        itemC1_3.setTipoPersonalizacao(tipoCaneca1);
        ItemPersonalizacaoTranslation ptItemC1_3 = new ItemPersonalizacaoTranslation();

        ptItemC1_3.setLocale(
                "pt-BR");
        ptItemC1_3.setTexto(
                "Fotos da família");
        ptItemC1_3.setItemPersonalizacao(itemC1_3);
        ItemPersonalizacaoTranslation enItemC1_3 = new ItemPersonalizacaoTranslation();

        enItemC1_3.setLocale(
                "en");
        enItemC1_3.setTexto(
                "Family photos");
        enItemC1_3.setItemPersonalizacao(itemC1_3);

        itemC1_3.getTranslations()
                .addAll(Arrays.asList(ptItemC1_3, enItemC1_3));
        tipoCaneca1.getItens()
                .add(itemC1_3);

// Item 4
        ItemPersonalizacao itemC1_4 = new ItemPersonalizacao();

        itemC1_4.setTipoPersonalizacao(tipoCaneca1);
        ItemPersonalizacaoTranslation ptItemC1_4 = new ItemPersonalizacaoTranslation();

        ptItemC1_4.setLocale(
                "pt-BR");
        ptItemC1_4.setTexto(
                "Mensagens de amor dos filhos");
        ptItemC1_4.setItemPersonalizacao(itemC1_4);
        ItemPersonalizacaoTranslation enItemC1_4 = new ItemPersonalizacaoTranslation();

        enItemC1_4.setLocale(
                "en");
        enItemC1_4.setTexto(
                "Loving messages from children");
        enItemC1_4.setItemPersonalizacao(itemC1_4);

        itemC1_4.getTranslations()
                .addAll(Arrays.asList(ptItemC1_4, enItemC1_4));
        tipoCaneca1.getItens()
                .add(itemC1_4);

// Item 5
        ItemPersonalizacao itemC1_5 = new ItemPersonalizacao();

        itemC1_5.setTipoPersonalizacao(tipoCaneca1);
        ItemPersonalizacaoTranslation ptItemC1_5 = new ItemPersonalizacaoTranslation();

        ptItemC1_5.setLocale(
                "pt-BR");
        ptItemC1_5.setTexto(
                "Desenhos das crianças");
        ptItemC1_5.setItemPersonalizacao(itemC1_5);
        ItemPersonalizacaoTranslation enItemC1_5 = new ItemPersonalizacaoTranslation();

        enItemC1_5.setLocale(
                "en");
        enItemC1_5.setTexto(
                "Children's drawings");
        enItemC1_5.setItemPersonalizacao(itemC1_5);

        itemC1_5.getTranslations()
                .addAll(Arrays.asList(ptItemC1_5, enItemC1_5));
        tipoCaneca1.getItens()
                .add(itemC1_5);

        TipoPersonalizacao tipoCaneca2 = new TipoPersonalizacao();

        tipoCaneca2.setNomeIcone(
                "users");
        tipoCaneca2.setCategoria(canecas);
        TipoPersonalizacaoTranslation ptTransC2 = new TipoPersonalizacaoTranslation();

        ptTransC2.setLocale(
                "pt-BR");
        ptTransC2.setTitulo(
                "Casais e Relacionamentos");
        ptTransC2.setTipoPersonalizacao(tipoCaneca2);
        TipoPersonalizacaoTranslation enTransC2 = new TipoPersonalizacaoTranslation();

        enTransC2.setLocale(
                "en");
        enTransC2.setTitulo(
                "Couples & Relationships");
        enTransC2.setTipoPersonalizacao(tipoCaneca2);

        tipoCaneca2.getTranslations()
                .addAll(Arrays.asList(ptTransC2, enTransC2));
        // --- Itens para "Casais e Relacionamentos" com tradução ---

// Item 1
        ItemPersonalizacao itemC2_1 = new ItemPersonalizacao();

        itemC2_1.setTipoPersonalizacao(tipoCaneca2);
        ItemPersonalizacaoTranslation ptItemC2_1 = new ItemPersonalizacaoTranslation();

        ptItemC2_1.setLocale(
                "pt-BR");
        ptItemC2_1.setTexto(
                "Data do primeiro encontro");
        ptItemC2_1.setItemPersonalizacao(itemC2_1);
        ItemPersonalizacaoTranslation enItemC2_1 = new ItemPersonalizacaoTranslation();

        enItemC2_1.setLocale(
                "en");
        enItemC2_1.setTexto(
                "First date anniversary");
        enItemC2_1.setItemPersonalizacao(itemC2_1);

        itemC2_1.getTranslations()
                .addAll(Arrays.asList(ptItemC2_1, enItemC2_1));
        tipoCaneca2.getItens()
                .add(itemC2_1);

// Item 2
        ItemPersonalizacao itemC2_2 = new ItemPersonalizacao();

        itemC2_2.setTipoPersonalizacao(tipoCaneca2);
        ItemPersonalizacaoTranslation ptItemC2_2 = new ItemPersonalizacaoTranslation();

        ptItemC2_2.setLocale(
                "pt-BR");
        ptItemC2_2.setTexto(
                "Fotos do casal");
        ptItemC2_2.setItemPersonalizacao(itemC2_2);
        ItemPersonalizacaoTranslation enItemC2_2 = new ItemPersonalizacaoTranslation();

        enItemC2_2.setLocale(
                "en");
        enItemC2_2.setTexto(
                "Couple photos");
        enItemC2_2.setItemPersonalizacao(itemC2_2);

        itemC2_2.getTranslations()
                .addAll(Arrays.asList(ptItemC2_2, enItemC2_2));
        tipoCaneca2.getItens()
                .add(itemC2_2);

// Item 3
        ItemPersonalizacao itemC2_3 = new ItemPersonalizacao();

        itemC2_3.setTipoPersonalizacao(tipoCaneca2);
        ItemPersonalizacaoTranslation ptItemC2_3 = new ItemPersonalizacaoTranslation();

        ptItemC2_3.setLocale(
                "pt-BR");
        ptItemC2_3.setTexto(
                "Frases especiais entre vocês");
        ptItemC2_3.setItemPersonalizacao(itemC2_3);
        ItemPersonalizacaoTranslation enItemC2_3 = new ItemPersonalizacaoTranslation();

        enItemC2_3.setLocale(
                "en");
        enItemC2_3.setTexto(
                "Special quotes between you");
        enItemC2_3.setItemPersonalizacao(itemC2_3);

        itemC2_3.getTranslations()
                .addAll(Arrays.asList(ptItemC2_3, enItemC2_3));
        tipoCaneca2.getItens()
                .add(itemC2_3);

// Item 4
        ItemPersonalizacao itemC2_4 = new ItemPersonalizacao();

        itemC2_4.setTipoPersonalizacao(tipoCaneca2);
        ItemPersonalizacaoTranslation ptItemC2_4 = new ItemPersonalizacaoTranslation();

        ptItemC2_4.setLocale(
                "pt-BR");
        ptItemC2_4.setTexto(
                "Coordenadas de lugares importantes");
        ptItemC2_4.setItemPersonalizacao(itemC2_4);
        ItemPersonalizacaoTranslation enItemC2_4 = new ItemPersonalizacaoTranslation();

        enItemC2_4.setLocale(
                "en");
        enItemC2_4.setTexto(
                "Coordinates of important places");
        enItemC2_4.setItemPersonalizacao(itemC2_4);

        itemC2_4.getTranslations()
                .addAll(Arrays.asList(ptItemC2_4, enItemC2_4));
        tipoCaneca2.getItens()
                .add(itemC2_4);

// Item 5
        ItemPersonalizacao itemC2_5 = new ItemPersonalizacao();

        itemC2_5.setTipoPersonalizacao(tipoCaneca2);
        ItemPersonalizacaoTranslation ptItemC2_5 = new ItemPersonalizacaoTranslation();

        ptItemC2_5.setLocale(
                "pt-BR");
        ptItemC2_5.setTexto(
                "Linha do tempo do relacionamento");
        ptItemC2_5.setItemPersonalizacao(itemC2_5);
        ItemPersonalizacaoTranslation enItemC2_5 = new ItemPersonalizacaoTranslation();

        enItemC2_5.setLocale(
                "en");
        enItemC2_5.setTexto(
                "Relationship timeline");
        enItemC2_5.setItemPersonalizacao(itemC2_5);

        itemC2_5.getTranslations()
                .addAll(Arrays.asList(ptItemC2_5, enItemC2_5));
        tipoCaneca2.getItens()
                .add(itemC2_5);

        TipoPersonalizacao tipoCaneca3 = new TipoPersonalizacao();

        tipoCaneca3.setNomeIcone(
                "sparkles");
        tipoCaneca3.setCategoria(canecas);
        TipoPersonalizacaoTranslation ptTransC3 = new TipoPersonalizacaoTranslation();

        ptTransC3.setLocale(
                "pt-BR");
        ptTransC3.setTitulo(
                "Motivacional");
        ptTransC3.setTipoPersonalizacao(tipoCaneca3);
        TipoPersonalizacaoTranslation enTransC3 = new TipoPersonalizacaoTranslation();

        enTransC3.setLocale(
                "en");
        enTransC3.setTitulo(
                "Motivational");
        enTransC3.setTipoPersonalizacao(tipoCaneca3);

        tipoCaneca3.getTranslations()
                .addAll(Arrays.asList(ptTransC3, enTransC3));
        // --- Itens para "Motivacional" com tradução ---

// Item 1
        ItemPersonalizacao itemC3_1 = new ItemPersonalizacao();

        itemC3_1.setTipoPersonalizacao(tipoCaneca3);
        ItemPersonalizacaoTranslation ptItemC3_1 = new ItemPersonalizacaoTranslation();

        ptItemC3_1.setLocale(
                "pt-BR");
        ptItemC3_1.setTexto(
                "Frases inspiradoras personalizadas");
        ptItemC3_1.setItemPersonalizacao(itemC3_1);
        ItemPersonalizacaoTranslation enItemC3_1 = new ItemPersonalizacaoTranslation();

        enItemC3_1.setLocale(
                "en");
        enItemC3_1.setTexto(
                "Custom inspirational quotes");
        enItemC3_1.setItemPersonalizacao(itemC3_1);

        itemC3_1.getTranslations()
                .addAll(Arrays.asList(ptItemC3_1, enItemC3_1));
        tipoCaneca3.getItens()
                .add(itemC3_1);

// Item 2
        ItemPersonalizacao itemC3_2 = new ItemPersonalizacao();

        itemC3_2.setTipoPersonalizacao(tipoCaneca3);
        ItemPersonalizacaoTranslation ptItemC3_2 = new ItemPersonalizacaoTranslation();

        ptItemC3_2.setLocale(
                "pt-BR");
        ptItemC3_2.setTexto(
                "Metas e objetivos");
        ptItemC3_2.setItemPersonalizacao(itemC3_2);
        ItemPersonalizacaoTranslation enItemC3_2 = new ItemPersonalizacaoTranslation();

        enItemC3_2.setLocale(
                "en");
        enItemC3_2.setTexto(
                "Goals and objectives");
        enItemC3_2.setItemPersonalizacao(itemC3_2);

        itemC3_2.getTranslations()
                .addAll(Arrays.asList(ptItemC3_2, enItemC3_2));
        tipoCaneca3.getItens()
                .add(itemC3_2);

// Item 3
        ItemPersonalizacao itemC3_3 = new ItemPersonalizacao();

        itemC3_3.setTipoPersonalizacao(tipoCaneca3);
        ItemPersonalizacaoTranslation ptItemC3_3 = new ItemPersonalizacaoTranslation();

        ptItemC3_3.setLocale(
                "pt-BR");
        ptItemC3_3.setTexto(
                "Versículos bíblicos");
        ptItemC3_3.setItemPersonalizacao(itemC3_3);
        ItemPersonalizacaoTranslation enItemC3_3 = new ItemPersonalizacaoTranslation();

        enItemC3_3.setLocale(
                "en");
        enItemC3_3.setTexto(
                "Bible verses");
        enItemC3_3.setItemPersonalizacao(itemC3_3);

        itemC3_3.getTranslations()
                .addAll(Arrays.asList(ptItemC3_3, enItemC3_3));
        tipoCaneca3.getItens()
                .add(itemC3_3);

// Item 4
        ItemPersonalizacao itemC3_4 = new ItemPersonalizacao();

        itemC3_4.setTipoPersonalizacao(tipoCaneca3);
        ItemPersonalizacaoTranslation ptItemC3_4 = new ItemPersonalizacaoTranslation();

        ptItemC3_4.setLocale(
                "pt-BR");
        ptItemC3_4.setTexto(
                "Mantras pessoais");
        ptItemC3_4.setItemPersonalizacao(itemC3_4);
        ItemPersonalizacaoTranslation enItemC3_4 = new ItemPersonalizacaoTranslation();

        enItemC3_4.setLocale(
                "en");
        enItemC3_4.setTexto(
                "Personal mantras");
        enItemC3_4.setItemPersonalizacao(itemC3_4);

        itemC3_4.getTranslations()
                .addAll(Arrays.asList(ptItemC3_4, enItemC3_4));
        tipoCaneca3.getItens()
                .add(itemC3_4);

// Item 5
        ItemPersonalizacao itemC3_5 = new ItemPersonalizacao();

        itemC3_5.setTipoPersonalizacao(tipoCaneca3);
        ItemPersonalizacaoTranslation ptItemC3_5 = new ItemPersonalizacaoTranslation();

        ptItemC3_5.setLocale(
                "pt-BR");
        ptItemC3_5.setTexto(
                "Conquistas e vitórias");
        ptItemC3_5.setItemPersonalizacao(itemC3_5);
        ItemPersonalizacaoTranslation enItemC3_5 = new ItemPersonalizacaoTranslation();

        enItemC3_5.setLocale(
                "en");
        enItemC3_5.setTexto(
                "Achievements and victories");
        enItemC3_5.setItemPersonalizacao(itemC3_5);

        itemC3_5.getTranslations()
                .addAll(Arrays.asList(ptItemC3_5, enItemC3_5));
        tipoCaneca3.getItens()
                .add(itemC3_5);

        TipoPersonalizacao tipoCaneca4 = new TipoPersonalizacao();

        tipoCaneca4.setNomeIcone(
                "gift");
        tipoCaneca4.setCategoria(canecas);
        TipoPersonalizacaoTranslation ptTransC4 = new TipoPersonalizacaoTranslation();

        ptTransC4.setLocale(
                "pt-BR");
        ptTransC4.setTitulo(
                "Datas Especiais");
        ptTransC4.setTipoPersonalizacao(tipoCaneca4);
        TipoPersonalizacaoTranslation enTransC4 = new TipoPersonalizacaoTranslation();

        enTransC4.setLocale(
                "en");
        enTransC4.setTitulo(
                "Special Dates");
        enTransC4.setTipoPersonalizacao(tipoCaneca4);

        tipoCaneca4.getTranslations()
                .addAll(Arrays.asList(ptTransC4, enTransC4));
        // --- Itens para "Datas Especiais" com tradução ---

// Item 1
        ItemPersonalizacao itemC4_1 = new ItemPersonalizacao();

        itemC4_1.setTipoPersonalizacao(tipoCaneca4);
        ItemPersonalizacaoTranslation ptItemC4_1 = new ItemPersonalizacaoTranslation();

        ptItemC4_1.setLocale(
                "pt-BR");
        ptItemC4_1.setTexto(
                "Aniversários únicos");
        ptItemC4_1.setItemPersonalizacao(itemC4_1);
        ItemPersonalizacaoTranslation enItemC4_1 = new ItemPersonalizacaoTranslation();

        enItemC4_1.setLocale(
                "en");
        enItemC4_1.setTexto(
                "Unique birthdays");
        enItemC4_1.setItemPersonalizacao(itemC4_1);

        itemC4_1.getTranslations()
                .addAll(Arrays.asList(ptItemC4_1, enItemC4_1));
        tipoCaneca4.getItens()
                .add(itemC4_1);

// Item 2
        ItemPersonalizacao itemC4_2 = new ItemPersonalizacao();

        itemC4_2.setTipoPersonalizacao(tipoCaneca4);
        ItemPersonalizacaoTranslation ptItemC4_2 = new ItemPersonalizacaoTranslation();

        ptItemC4_2.setLocale(
                "pt-BR");
        ptItemC4_2.setTexto(
                "Formaturas e conquistas");
        ptItemC4_2.setItemPersonalizacao(itemC4_2);
        ItemPersonalizacaoTranslation enItemC4_2 = new ItemPersonalizacaoTranslation();

        enItemC4_2.setLocale(
                "en");
        enItemC4_2.setTexto(
                "Graduations and achievements");
        enItemC4_2.setItemPersonalizacao(itemC4_2);

        itemC4_2.getTranslations()
                .addAll(Arrays.asList(ptItemC4_2, enItemC4_2));
        tipoCaneca4.getItens()
                .add(itemC4_2);

// Item 3
        ItemPersonalizacao itemC4_3 = new ItemPersonalizacao();

        itemC4_3.setTipoPersonalizacao(tipoCaneca4);
        ItemPersonalizacaoTranslation ptItemC4_3 = new ItemPersonalizacaoTranslation();

        ptItemC4_3.setLocale(
                "pt-BR");
        ptItemC4_3.setTexto(
                "Aposentadoria");
        ptItemC4_3.setItemPersonalizacao(itemC4_3);
        ItemPersonalizacaoTranslation enItemC4_3 = new ItemPersonalizacaoTranslation();

        enItemC4_3.setLocale(
                "en");
        enItemC4_3.setTexto(
                "Retirement");
        enItemC4_3.setItemPersonalizacao(itemC4_3);

        itemC4_3.getTranslations()
                .addAll(Arrays.asList(ptItemC4_3, enItemC4_3));
        tipoCaneca4.getItens()
                .add(itemC4_3);

// Item 4
        ItemPersonalizacao itemC4_4 = new ItemPersonalizacao();

        itemC4_4.setTipoPersonalizacao(tipoCaneca4);
        ItemPersonalizacaoTranslation ptItemC4_4 = new ItemPersonalizacaoTranslation();

        ptItemC4_4.setLocale(
                "pt-BR");
        ptItemC4_4.setTexto(
                "Nascimento de bebês");
        ptItemC4_4.setItemPersonalizacao(itemC4_4);
        ItemPersonalizacaoTranslation enItemC4_4 = new ItemPersonalizacaoTranslation();

        enItemC4_4.setLocale(
                "en");
        enItemC4_4.setTexto(
                "Newborn celebrations");
        enItemC4_4.setItemPersonalizacao(itemC4_4);

        itemC4_4.getTranslations()
                .addAll(Arrays.asList(ptItemC4_4, enItemC4_4));
        tipoCaneca4.getItens()
                .add(itemC4_4);

// Item 5
        ItemPersonalizacao itemC4_5 = new ItemPersonalizacao();

        itemC4_5.setTipoPersonalizacao(tipoCaneca4);
        ItemPersonalizacaoTranslation ptItemC4_5 = new ItemPersonalizacaoTranslation();

        ptItemC4_5.setLocale(
                "pt-BR");
        ptItemC4_5.setTexto(
                "Bodas e aniversários de casamento");
        ptItemC4_5.setItemPersonalizacao(itemC4_5);
        ItemPersonalizacaoTranslation enItemC4_5 = new ItemPersonalizacaoTranslation();

        enItemC4_5.setLocale(
                "en");
        enItemC4_5.setTexto(
                "Wedding anniversaries");
        enItemC4_5.setItemPersonalizacao(itemC4_5);

        itemC4_5.getTranslations()
                .addAll(Arrays.asList(ptItemC4_5, enItemC4_5));
        tipoCaneca4.getItens()
                .add(itemC4_5);

        TipoPersonalizacao tipoCaneca5 = new TipoPersonalizacao();

        tipoCaneca5.setNomeIcone(
                "coffee");
        tipoCaneca5.setCategoria(canecas);
        TipoPersonalizacaoTranslation ptTransC5 = new TipoPersonalizacaoTranslation();

        ptTransC5.setLocale(
                "pt-BR");
        ptTransC5.setTitulo(
                "Profissional");
        ptTransC5.setTipoPersonalizacao(tipoCaneca5);
        TipoPersonalizacaoTranslation enTransC5 = new TipoPersonalizacaoTranslation();

        enTransC5.setLocale(
                "en");
        enTransC5.setTitulo(
                "Professional");
        enTransC5.setTipoPersonalizacao(tipoCaneca5);

        tipoCaneca5.getTranslations()
                .addAll(Arrays.asList(ptTransC5, enTransC5));
        // --- Itens para "Profissional" com tradução ---

// Item 1
        ItemPersonalizacao itemC5_1 = new ItemPersonalizacao();

        itemC5_1.setTipoPersonalizacao(tipoCaneca5);
        ItemPersonalizacaoTranslation ptItemC5_1 = new ItemPersonalizacaoTranslation();

        ptItemC5_1.setLocale(
                "pt-BR");
        ptItemC5_1.setTexto(
                "Logo da empresa");
        ptItemC5_1.setItemPersonalizacao(itemC5_1);
        ItemPersonalizacaoTranslation enItemC5_1 = new ItemPersonalizacaoTranslation();

        enItemC5_1.setLocale(
                "en");
        enItemC5_1.setTexto(
                "Company logo");
        enItemC5_1.setItemPersonalizacao(itemC5_1);

        itemC5_1.getTranslations()
                .addAll(Arrays.asList(ptItemC5_1, enItemC5_1));
        tipoCaneca5.getItens()
                .add(itemC5_1);

// Item 2
        ItemPersonalizacao itemC5_2 = new ItemPersonalizacao();

        itemC5_2.setTipoPersonalizacao(tipoCaneca5);
        ItemPersonalizacaoTranslation ptItemC5_2 = new ItemPersonalizacaoTranslation();

        ptItemC5_2.setLocale(
                "pt-BR");
        ptItemC5_2.setTexto(
                "Nome e cargo personalizado");
        ptItemC5_2.setItemPersonalizacao(itemC5_2);
        ItemPersonalizacaoTranslation enItemC5_2 = new ItemPersonalizacaoTranslation();

        enItemC5_2.setLocale(
                "en");
        enItemC5_2.setTexto(
                "Custom name and title");
        enItemC5_2.setItemPersonalizacao(itemC5_2);

        itemC5_2.getTranslations()
                .addAll(Arrays.asList(ptItemC5_2, enItemC5_2));
        tipoCaneca5.getItens()
                .add(itemC5_2);

// Item 3
        ItemPersonalizacao itemC5_3 = new ItemPersonalizacao();

        itemC5_3.setTipoPersonalizacao(tipoCaneca5);
        ItemPersonalizacaoTranslation ptItemC5_3 = new ItemPersonalizacaoTranslation();

        ptItemC5_3.setLocale(
                "pt-BR");
        ptItemC5_3.setTexto(
                "Brindes corporativos");
        ptItemC5_3.setItemPersonalizacao(itemC5_3);
        ItemPersonalizacaoTranslation enItemC5_3 = new ItemPersonalizacaoTranslation();

        enItemC5_3.setLocale(
                "en");
        enItemC5_3.setTexto(
                "Corporate gifts");
        enItemC5_3.setItemPersonalizacao(itemC5_3);

        itemC5_3.getTranslations()
                .addAll(Arrays.asList(ptItemC5_3, enItemC5_3));
        tipoCaneca5.getItens()
                .add(itemC5_3);

// Item 4
        ItemPersonalizacao itemC5_4 = new ItemPersonalizacao();

        itemC5_4.setTipoPersonalizacao(tipoCaneca5);
        ItemPersonalizacaoTranslation ptItemC5_4 = new ItemPersonalizacaoTranslation();

        ptItemC5_4.setLocale(
                "pt-BR");
        ptItemC5_4.setTexto(
                "Eventos e convenções");
        ptItemC5_4.setItemPersonalizacao(itemC5_4);
        ItemPersonalizacaoTranslation enItemC5_4 = new ItemPersonalizacaoTranslation();

        enItemC5_4.setLocale(
                "en");
        enItemC5_4.setTexto(
                "Events and conventions");
        enItemC5_4.setItemPersonalizacao(itemC5_4);

        itemC5_4.getTranslations()
                .addAll(Arrays.asList(ptItemC5_4, enItemC5_4));
        tipoCaneca5.getItens()
                .add(itemC5_4);

// Item 5
        ItemPersonalizacao itemC5_5 = new ItemPersonalizacao();

        itemC5_5.setTipoPersonalizacao(tipoCaneca5);
        ItemPersonalizacaoTranslation ptItemC5_5 = new ItemPersonalizacaoTranslation();

        ptItemC5_5.setLocale(
                "pt-BR");
        ptItemC5_5.setTexto(
                "Presentes para equipe");
        ptItemC5_5.setItemPersonalizacao(itemC5_5);
        ItemPersonalizacaoTranslation enItemC5_5 = new ItemPersonalizacaoTranslation();

        enItemC5_5.setLocale(
                "en");
        enItemC5_5.setTexto(
                "Gifts for the team");
        enItemC5_5.setItemPersonalizacao(itemC5_5);

        itemC5_5.getTranslations()
                .addAll(Arrays.asList(ptItemC5_5, enItemC5_5));
        tipoCaneca5.getItens()
                .add(itemC5_5);

        TipoPersonalizacao tipoCaneca6 = new TipoPersonalizacao();

        tipoCaneca6.setNomeIcone(
                "palette");
        tipoCaneca6.setCategoria(canecas);
        TipoPersonalizacaoTranslation ptTransC6 = new TipoPersonalizacaoTranslation();

        ptTransC6.setLocale(
                "pt-BR");
        ptTransC6.setTitulo(
                "Arte Personalizada");
        ptTransC6.setTipoPersonalizacao(tipoCaneca6);
        TipoPersonalizacaoTranslation enTransC6 = new TipoPersonalizacaoTranslation();

        enTransC6.setLocale(
                "en");
        enTransC6.setTitulo(
                "Custom Art");
        enTransC6.setTipoPersonalizacao(tipoCaneca6);

        tipoCaneca6.getTranslations()
                .addAll(Arrays.asList(ptTransC6, enTransC6));
        // --- Itens para "Arte Personalizada" com tradução ---

// Item 1
        ItemPersonalizacao itemC6_1 = new ItemPersonalizacao();

        itemC6_1.setTipoPersonalizacao(tipoCaneca6);
        ItemPersonalizacaoTranslation ptItemC6_1 = new ItemPersonalizacaoTranslation();

        ptItemC6_1.setLocale(
                "pt-BR");
        ptItemC6_1.setTexto(
                "Ilustrações exclusivas");
        ptItemC6_1.setItemPersonalizacao(itemC6_1);
        ItemPersonalizacaoTranslation enItemC6_1 = new ItemPersonalizacaoTranslation();

        enItemC6_1.setLocale(
                "en");
        enItemC6_1.setTexto(
                "Exclusive illustrations");
        enItemC6_1.setItemPersonalizacao(itemC6_1);

        itemC6_1.getTranslations()
                .addAll(Arrays.asList(ptItemC6_1, enItemC6_1));
        tipoCaneca6.getItens()
                .add(itemC6_1);

// Item 2
        ItemPersonalizacao itemC6_2 = new ItemPersonalizacao();

        itemC6_2.setTipoPersonalizacao(tipoCaneca6);
        ItemPersonalizacaoTranslation ptItemC6_2 = new ItemPersonalizacaoTranslation();

        ptItemC6_2.setLocale(
                "pt-BR");
        ptItemC6_2.setTexto(
                "Retratos artísticos");
        ptItemC6_2.setItemPersonalizacao(itemC6_2);
        ItemPersonalizacaoTranslation enItemC6_2 = new ItemPersonalizacaoTranslation();

        enItemC6_2.setLocale(
                "en");
        enItemC6_2.setTexto(
                "Artistic portraits");
        enItemC6_2.setItemPersonalizacao(itemC6_2);

        itemC6_2.getTranslations()
                .addAll(Arrays.asList(ptItemC6_2, enItemC6_2));
        tipoCaneca6.getItens()
                .add(itemC6_2);

// Item 3
        ItemPersonalizacao itemC6_3 = new ItemPersonalizacao();

        itemC6_3.setTipoPersonalizacao(tipoCaneca6);
        ItemPersonalizacaoTranslation ptItemC6_3 = new ItemPersonalizacaoTranslation();

        ptItemC6_3.setLocale(
                "pt-BR");
        ptItemC6_3.setTexto(
                "Pets e animais de estimação");
        ptItemC6_3.setItemPersonalizacao(itemC6_3);
        ItemPersonalizacaoTranslation enItemC6_3 = new ItemPersonalizacaoTranslation();

        enItemC6_3.setLocale(
                "en");
        enItemC6_3.setTexto(
                "Pets and companion animals");
        enItemC6_3.setItemPersonalizacao(itemC6_3);

        itemC6_3.getTranslations()
                .addAll(Arrays.asList(ptItemC6_3, enItemC6_3));
        tipoCaneca6.getItens()
                .add(itemC6_3);

// Item 4
        ItemPersonalizacao itemC6_4 = new ItemPersonalizacao();

        itemC6_4.setTipoPersonalizacao(tipoCaneca6);
        ItemPersonalizacaoTranslation ptItemC6_4 = new ItemPersonalizacaoTranslation();

        ptItemC6_4.setLocale(
                "pt-BR");
        ptItemC6_4.setTexto(
                "Paisagens especiais");
        ptItemC6_4.setItemPersonalizacao(itemC6_4);
        ItemPersonalizacaoTranslation enItemC6_4 = new ItemPersonalizacaoTranslation();

        enItemC6_4.setLocale(
                "en");
        enItemC6_4.setTexto(
                "Special landscapes");
        enItemC6_4.setItemPersonalizacao(itemC4_1);

        itemC6_4.getTranslations()
                .addAll(Arrays.asList(ptItemC6_4, enItemC6_4));
        tipoCaneca6.getItens()
                .add(itemC6_4);

// Item 5
        ItemPersonalizacao itemC6_5 = new ItemPersonalizacao();

        itemC6_5.setTipoPersonalizacao(tipoCaneca6);
        ItemPersonalizacaoTranslation ptItemC6_5 = new ItemPersonalizacaoTranslation();

        ptItemC6_5.setLocale(
                "pt-BR");
        ptItemC6_5.setTexto(
                "Arte abstrata personalizada");
        ptItemC6_5.setItemPersonalizacao(itemC6_5);
        ItemPersonalizacaoTranslation enItemC6_5 = new ItemPersonalizacaoTranslation();

        enItemC6_5.setLocale(
                "en");
        enItemC6_5.setTexto(
                "Custom abstract art");
        enItemC6_5.setItemPersonalizacao(itemC6_5);

        itemC6_5.getTranslations()
                .addAll(Arrays.asList(ptItemC6_5, enItemC6_5));
        tipoCaneca6.getItens()
                .add(itemC6_5);
// Salva todos os tipos de personalização para 'Canecas' de uma vez
        tipoPersonalizacaoRepository.saveAll(Arrays.asList(tipoCaneca1, tipoCaneca2, tipoCaneca3, tipoCaneca4, tipoCaneca5, tipoCaneca6));
        // --- CATEGORIA BOLSAS ---
        // --- CATEGORIA BOLSAS ---
    }

    private void criarCategoriaBolsas() {
        Categoria bolsas = new Categoria();
// 1. Defina os campos que NÃO são traduzidos

        bolsas.setSlug(
                "bolsas");
        bolsas.setImagemDestaqueUrl(
                "/images/Produtos/Bolsa/Bolsa Tote 4 Estilos.jpeg");
        bolsas.setUrlImagemPersonalizacao(
                "/images/Produtos/Bolsa/800x800 Foto Tati Bolsa.png");
        bolsas.setImagemUrlHome(
                "/images/Home/960x640 Bolsas Tote.png");

// 2. Crie a tradução para Português (pt-BR)
        CategoriaTranslation ptBolsas = new CategoriaTranslation();

        ptBolsas.setLocale(
                "pt-BR");
        ptBolsas.setCategoria(bolsas);

        ptBolsas.setNomeSingular(
                "Bolsa");
        ptBolsas.setNomePlural(
                "Bolsas Personalizadas");
        ptBolsas.setDescricao(
                "Carregue sua história todos os dias. Cada bolsa é uma obra de arte única, criada especialmente para expressar sua personalidade e acompanhar seus momentos mais especiais.");
        ptBolsas.setCtaTitle(
                "Carregue Sua História Com Estilo!");
        ptBolsas.setCtaDescription(
                "Sua personalidade é única, sua bolsa também deveria ser. Que tal transformar seu dia a dia com uma bolsa que conta sua história e expressa quem você realmente é? Vamos criar juntas sua obra de arte pessoal?");
        ptBolsas.setCtaAttention(
                "⚡ OPORTUNIDADE LIMITADA: Devido à alta procura por bolsas personalizadas, estamos com lista de espera. Reserve já a sua para não perder!");
        ptBolsas.setCtaButtonText(
                "✨ SIM! Quero Minha Bolsa Única Agora");
        ptBolsas.setHeroTitle(
                "Bolsas Personalizadas que Falam Sobre Você");
        ptBolsas.setHeroButtonText(
                "💝 Criar Minha Bolsa Única");
        ptBolsas.setGaleriaTitle(
                "Cada Bolsa é uma Obra de Arte Feita para Você");
        ptBolsas.setGaleriaDescricao(
                "Veja como transformamos sonhos em bolsas de luxo personalizado. Cada detalhe é pensado para refletir sua essência e elevar seu estilo diário.");

// 3. Crie a tradução para Inglês (en)
        CategoriaTranslation enBolsas = new CategoriaTranslation();

        enBolsas.setLocale(
                "en");
        enBolsas.setCategoria(bolsas);

        enBolsas.setNomeSingular(
                "Bag");
        enBolsas.setNomePlural(
                "Custom Bags");
        enBolsas.setDescricao(
                "Carry your story every day. Each bag is a unique work of art, specially created to express your personality and accompany your most special moments.");
        enBolsas.setCtaTitle(
                "Carry Your Story With Style!");
        enBolsas.setCtaDescription(
                "Your personality is unique, and your bag should be too. How about transforming your day-to-day with a bag that tells your story and expresses who you truly are? Let's create your personal masterpiece together?");
        enBolsas.setCtaAttention(
                "⚡ LIMITED OPPORTUNITY: Due to high demand for custom bags, we have a waiting list. Reserve yours now so you don't miss out!");
        enBolsas.setCtaButtonText(
                "✨ YES! I Want My Unique Bag Now");
        enBolsas.setHeroTitle(
                "Personalized Bags that Speak About You");
        enBolsas.setHeroButtonText(
                "💝 Create My Unique Bag");
        enBolsas.setGaleriaTitle(
                "Each Bag is a Work of Art Made for You");
        enBolsas.setGaleriaDescricao(
                "See how we transform dreams into luxury bags. Each detail is designed to reflect your essence and elevate your daily style.");

// 4. Adicione as traduções à categoria e salve
        bolsas.getTranslations()
                .addAll(Arrays.asList(ptBolsas, enBolsas));
        categoriaRepository.save(bolsas);

        // Produtos para a categoria Bolsas
        // --- Produtos para a categoria Bolsas (CORRIGIDO) ---
// Produto 1
        Produto b1 = new Produto("/images/Produtos/Bolsa/790x770 Bolsas Tote Fundo Branco.png", bolsas);
        ProdutoTranslation ptB1 = new ProdutoTranslation();

        ptB1.setLocale(
                "pt-BR");
        ptB1.setNome(
                "Elegância no Dia a Dia");
        ptB1.setDescricao(
                "Bolsas Tote que combinam sofisticação e praticidade da mulher moderna");
        ptB1.setProduto(b1);
        ProdutoTranslation enB1 = new ProdutoTranslation();

        enB1.setLocale(
                "en");
        enB1.setNome(
                "Everyday Elegance");
        enB1.setDescricao(
                "Bags that combine sophistication and practicality");
        enB1.setProduto(b1);

        b1.getTranslations()
                .addAll(Arrays.asList(ptB1, enB1));
        produtoRepository.save(b1);

// Produto 2
        Produto b2 = new Produto("/images/Produtos/Bolsa/790x770 Bolsa Vermlha Fundo Branco.png", bolsas);
        ProdutoTranslation ptB2 = new ProdutoTranslation();

        ptB2.setLocale(
                "pt-BR");
        ptB2.setNome(
                "Personalidade Vibrante");
        ptB2.setDescricao(
                "Cores que expressam sua energia e desenhos que contam sua história");
        ptB2.setProduto(b2);
        ProdutoTranslation enB2 = new ProdutoTranslation();

        enB2.setLocale(
                "en");
        enB2.setNome(
                "Vibrant Personality");
        enB2.setDescricao(
                "Colors that express your energy and designs that tell your story");
        enB2.setProduto(b2);

        b2.getTranslations()
                .addAll(Arrays.asList(ptB2, enB2));
        produtoRepository.save(b2);

// Produto 3
        Produto b3 = new Produto("/images/Produtos/Bolsa/790x770 Bolsa Branca e Preta fundo Branco.png", bolsas);
        ProdutoTranslation ptB3 = new ProdutoTranslation();

        ptB3.setLocale(
                "pt-BR");
        ptB3.setNome(
                "Clássico Atemporal");
        ptB3.setDescricao(
                "Design minimalista que nunca sai de moda, perfeita para qualquer ocasião");
        ptB3.setProduto(b3);
        ProdutoTranslation enB3 = new ProdutoTranslation();

        enB3.setLocale(
                "en");
        enB3.setNome(
                "Timeless Classic");
        enB3.setDescricao(
                "Minimalist design that never goes out of style, perfect for any occasion");
        enB3.setProduto(b3);

        b3.getTranslations()
                .addAll(Arrays.asList(ptB3, enB3));
        produtoRepository.save(b3);

        // Adicione os depoimentos para bolsas
        Depoimento db1 = new Depoimento("Carla Fernandes", "\"Gente, que bolsa PERFEITA! 😍 As 'Mulheres Poderosas' ficaram lindas demais! Recebo elogios todos os dias. É exatamente o que eu sonhava - forte, elegante e única! 💪✨\"", "/images/Produtos/Bolsa/790x770 Bolsas Mulheres Poderosas Experience.png", bolsas);
        Depoimento db2 = new Depoimento("Marina Silva", "\"Minha bolsa vermelha é TUDO! ❤️ A qualidade é incrível, o tamanho perfeito para o trabalho e o design é simplesmente maravilhoso. Já encomendei outra para minha irmã! 🥰\"", "/images/Produtos/Bolsa/Bolsa Vermelha com Modelo.jpeg", bolsas);
        Depoimento db3 = new Depoimento("Larissa Costa", "\"Estou APAIXONADA pela minha bolsa tote! O cuidado na embalagem, a qualidade dos materiais... Sinto que carrego um pedaço de arte comigo. Recomendo de olhos fechados! 💝\"", "/images/Produtos/Bolsa/790x770 Bolsas Tote Depoimento.png", bolsas);

        depoimentoRepository.saveAll(Arrays.asList(db1, db2, db3));

        // --- TIPOS DE PERSONALIZAÇÃO PARA A CATEGORIA 'BOLSAS' (CORRIGIDO) ---
        TipoPersonalizacao tipoBolsa1 = new TipoPersonalizacao();

        tipoBolsa1.setNomeIcone(
                "palette");
        tipoBolsa1.setCategoria(bolsas);
        TipoPersonalizacaoTranslation ptTransB1 = new TipoPersonalizacaoTranslation();

        ptTransB1.setLocale(
                "pt-BR");
        ptTransB1.setTitulo(
                "Cores do Tecido");
        ptTransB1.setTipoPersonalizacao(tipoBolsa1);
        TipoPersonalizacaoTranslation enTransB1 = new TipoPersonalizacaoTranslation();

        enTransB1.setLocale(
                "en");
        enTransB1.setTitulo(
                "Colors of the Fabric");
        enTransB1.setTipoPersonalizacao(tipoBolsa1);

        tipoBolsa1.getTranslations()
                .addAll(Arrays.asList(ptTransB1, enTransB1));
        // --- Itens para "Minimalista Elegante" com tradução ---

// Item 1
        ItemPersonalizacao itemB1_1 = new ItemPersonalizacao();

        itemB1_1.setTipoPersonalizacao(tipoBolsa1);
        ItemPersonalizacaoTranslation ptItemB1_1 = new ItemPersonalizacaoTranslation();

        ptItemB1_1.setLocale(
                "pt-BR");
        ptItemB1_1.setTexto(
                "Diversas opções de cores exclusivas");
        ptItemB1_1.setItemPersonalizacao(itemB1_1);
        ItemPersonalizacaoTranslation enItemB1_1 = new ItemPersonalizacaoTranslation();

        enItemB1_1.setLocale(
                "en");
        enItemB1_1.setTexto(
                "Exclusive color options");
        enItemB1_1.setItemPersonalizacao(itemB1_1);

        itemB1_1.getTranslations()
                .addAll(Arrays.asList(ptItemB1_1, enItemB1_1));
        tipoBolsa1.getItens()
                .add(itemB1_1);

// Item 2
        ItemPersonalizacao itemB1_2 = new ItemPersonalizacao();

        itemB1_2.setTipoPersonalizacao(tipoBolsa1);
        ItemPersonalizacaoTranslation ptItemB1_2 = new ItemPersonalizacaoTranslation();

        ptItemB1_2.setLocale(
                "pt-BR");
        ptItemB1_2.setTexto(
                "Combine tons para criar sua bolsa única");
        ptItemB1_2.setItemPersonalizacao(itemB1_2);
        ItemPersonalizacaoTranslation enItemB1_2 = new ItemPersonalizacaoTranslation();

        enItemB1_2.setLocale(
                "en");
        enItemB1_2.setTexto(
                "Combine tones to create your unique bag");
        enItemB1_2.setItemPersonalizacao(itemB1_2);

        itemB1_2.getTranslations()
                .addAll(Arrays.asList(ptItemB1_2, enItemB1_2));
        tipoBolsa1.getItens()
                .add(itemB1_2);

// Item 3
        ItemPersonalizacao itemB1_3 = new ItemPersonalizacao();

        itemB1_3.setTipoPersonalizacao(tipoBolsa1);
        ItemPersonalizacaoTranslation ptItemB1_3 = new ItemPersonalizacaoTranslation();

        ptItemB1_3.setLocale(
                "pt-BR");
        ptItemB1_3.setTexto(
                "Escolha a cor que mais combina com você");
        ptItemB1_3.setItemPersonalizacao(itemB1_3);
        ItemPersonalizacaoTranslation enItemB1_3 = new ItemPersonalizacaoTranslation();

        enItemB1_3.setLocale(
                "en");
        enItemB1_3.setTexto(
                "Choose the color that best matches you");
        enItemB1_3.setItemPersonalizacao(itemB1_3);

        itemB1_3.getTranslations()
                .addAll(Arrays.asList(ptItemB1_3, enItemB1_3));
        tipoBolsa1.getItens()
                .add(itemB1_3);


        TipoPersonalizacao tipoBolsa2 = new TipoPersonalizacao();
        tipoBolsa2.setNomeIcone(
                "star");
        tipoBolsa2.setCategoria(bolsas);
        TipoPersonalizacaoTranslation ptTransB2 = new TipoPersonalizacaoTranslation();

        ptTransB2.setLocale(
                "pt-BR");
        ptTransB2.setTitulo(
                "Escolha o acabamento");
        ptTransB2.setTipoPersonalizacao(tipoBolsa2);
        TipoPersonalizacaoTranslation enTransB2 = new TipoPersonalizacaoTranslation();

        enTransB2.setLocale(
                "en");
        enTransB2.setTitulo(
                "Choose the finish");
        enTransB2.setTipoPersonalizacao(tipoBolsa2);

        tipoBolsa2.getTranslations()
                .addAll(Arrays.asList(ptTransB2, enTransB2));

// Item 1
        ItemPersonalizacao itemB2_1 = new ItemPersonalizacao();

        itemB2_1.setTipoPersonalizacao(tipoBolsa2);
        ItemPersonalizacaoTranslation ptItemB2_1 = new ItemPersonalizacaoTranslation();

        ptItemB2_1.setLocale(
                "pt-BR");
        ptItemB2_1.setTexto(
                "Escolha entre ferragens prata ou ouro");
        ptItemB2_1.setItemPersonalizacao(itemB2_1);
        ItemPersonalizacaoTranslation enItemB2_1 = new ItemPersonalizacaoTranslation();

        enItemB2_1.setLocale(
                "en");
        enItemB2_1.setTexto(
                "Choose between silver or gold hardware");
        enItemB2_1.setItemPersonalizacao(itemB2_1);

        itemB2_1.getTranslations()
                .addAll(Arrays.asList(ptItemB2_1, enItemB2_1));
        tipoBolsa2.getItens()
                .add(itemB2_1);

// Item 2
        ItemPersonalizacao itemB2_2 = new ItemPersonalizacao();

        itemB2_2.setTipoPersonalizacao(tipoBolsa2);
        ItemPersonalizacaoTranslation ptItemB2_2 = new ItemPersonalizacaoTranslation();

        ptItemB2_2.setLocale(
                "pt-BR");
        ptItemB2_2.setTexto(
                "Detalhes que valorizam sua bolsa");
        ptItemB2_2.setItemPersonalizacao(itemB2_2);
        ItemPersonalizacaoTranslation enItemB2_2 = new ItemPersonalizacaoTranslation();

        enItemB2_2.setLocale(
                "en");
        enItemB2_2.setTexto(
                "Details that value your bag");
        enItemB2_2.setItemPersonalizacao(itemB2_2);

        itemB2_2.getTranslations()
                .addAll(Arrays.asList(ptItemB2_2, enItemB2_2));
        tipoBolsa2.getItens()
                .add(itemB2_2);

// Item 3
        ItemPersonalizacao itemB2_3 = new ItemPersonalizacao();

        itemB2_3.setTipoPersonalizacao(tipoBolsa2);
        ItemPersonalizacaoTranslation ptItemB2_3 = new ItemPersonalizacaoTranslation();

        ptItemB2_3.setLocale(
                "pt-BR");
        ptItemB2_3.setTexto(
                "Acabamento sofisticado e durável");
        ptItemB2_3.setItemPersonalizacao(itemB2_3);
        ItemPersonalizacaoTranslation enItemB2_3 = new ItemPersonalizacaoTranslation();

        enItemB2_3.setLocale(
                "en");
        enItemB2_3.setTexto(
                "Sophisticated and durable finish");
        enItemB2_3.setItemPersonalizacao(itemB2_3);

        itemB2_3.getTranslations()
                .addAll(Arrays.asList(ptItemB2_3, enItemB2_3));
        tipoBolsa2.getItens()
                .add(itemB2_3);


        TipoPersonalizacao tipoBolsa3 = new TipoPersonalizacao();

        tipoBolsa3.setNomeIcone(
                "briefcase");
        tipoBolsa3.setCategoria(bolsas);
        TipoPersonalizacaoTranslation ptTransB3 = new TipoPersonalizacaoTranslation();

        ptTransB3.setLocale(
                "pt-BR");
        ptTransB3.setTitulo(
                "Modelo da Bolsa");
        ptTransB3.setTipoPersonalizacao(tipoBolsa3);
        TipoPersonalizacaoTranslation enTransB3 = new TipoPersonalizacaoTranslation();

        enTransB3.setLocale(
                "en");
        enTransB3.setTitulo(
                "Bag Model");
        enTransB3.setTipoPersonalizacao(tipoBolsa3);

        tipoBolsa3.getTranslations()
                .addAll(Arrays.asList(ptTransB3, enTransB3));
        // --- Itens para "Artística Única" com tradução ---

// Item 1
        ItemPersonalizacao itemB3_1 = new ItemPersonalizacao();

        itemB3_1.setTipoPersonalizacao(tipoBolsa3);
        ItemPersonalizacaoTranslation ptItemB3_1 = new ItemPersonalizacaoTranslation();

        ptItemB3_1.setLocale(
                "pt-BR");
        ptItemB3_1.setTexto(
                "Tamanho perfeito para caber o que você precisa");
        ptItemB3_1.setItemPersonalizacao(itemB3_1);
        ItemPersonalizacaoTranslation enItemB3_1 = new ItemPersonalizacaoTranslation();

        enItemB3_1.setLocale(
                "en");
        enItemB3_1.setTexto(
                "Perfect size to fit what you need");
        enItemB3_1.setItemPersonalizacao(itemB3_1);

        itemB3_1.getTranslations()
                .addAll(Arrays.asList(ptItemB3_1, enItemB3_1));
        tipoBolsa3.getItens()
                .add(itemB3_1);

// Item 2
        ItemPersonalizacao itemB3_2 = new ItemPersonalizacao();

        itemB3_2.setTipoPersonalizacao(tipoBolsa3);
        ItemPersonalizacaoTranslation ptItemB3_2 = new ItemPersonalizacaoTranslation();

        ptItemB3_2.setLocale(
                "pt-BR");
        ptItemB3_2.setTexto(
                "Opções de alça e compartimentos");
        ptItemB3_2.setItemPersonalizacao(itemB3_2);
        ItemPersonalizacaoTranslation enItemB3_2 = new ItemPersonalizacaoTranslation();

        enItemB3_2.setLocale(
                "en");
        enItemB3_2.setTexto(
                "Options for handles and compartments");
        enItemB3_2.setItemPersonalizacao(itemB3_2);

        itemB3_2.getTranslations()
                .addAll(Arrays.asList(ptItemB3_2, enItemB3_2));
        tipoBolsa3.getItens()
                .add(itemB3_2);

// Item 3
        ItemPersonalizacao itemB3_3 = new ItemPersonalizacao();

        itemB3_3.setTipoPersonalizacao(tipoBolsa3);
        ItemPersonalizacaoTranslation ptItemB3_3 = new ItemPersonalizacaoTranslation();

        ptItemB3_3.setLocale(
                "pt-BR");
        ptItemB3_3.setTexto(
                "Modelos para diferentes ocasiões");
        ptItemB3_3.setItemPersonalizacao(itemB3_3);
        ItemPersonalizacaoTranslation enItemB3_3 = new ItemPersonalizacaoTranslation();

        enItemB3_3.setLocale(
                "en");
        enItemB3_3.setTexto(
                "Options for different occasions");
        enItemB3_3.setItemPersonalizacao(itemB3_3);

        itemB3_3.getTranslations()
                .addAll(Arrays.asList(ptItemB3_3, enItemB3_3));
        tipoBolsa3.getItens()
                .add(itemB3_3);



// Salva todos os tipos de personalização para 'Bolsas' de uma vez
        tipoPersonalizacaoRepository.saveAll(Arrays.asList(tipoBolsa1, tipoBolsa2, tipoBolsa3));

    }
    // --- CATEGORIA ESTOJOS ---
    // --- CATEGORIA ESTOJOS ---

    private void criarCategoriaEstojos() {
        Categoria estojos = new Categoria();
// 1. Defina os campos que NÃO são traduzidos

        estojos.setSlug(
                "estojos");
        estojos.setImagemDestaqueUrl(
                "/images/Produtos/Estojo/960x640 Estojo Tatiart.png");
        estojos.setUrlImagemPersonalizacao(
                "/images/Produtos/Estojo/Estojo Turma Animais.jpeg");
        estojos.setImagemUrlHome(
                "/images/Home/KitEstojos - Categoria.jpg");

// 2. Crie a tradução para Português (pt-BR)
        CategoriaTranslation ptEstojos = new CategoriaTranslation();

        ptEstojos.setLocale(
                "pt-BR");
        ptEstojos.setCategoria(estojos);

        ptEstojos.setNomeSingular(
                "Estojo");
        ptEstojos.setNomePlural(
                "Estojos Personalizados");
        ptEstojos.setDescricao(
                "Estojos personalizados que encantam crianças e organizam o material escolar com estilo e personalidade.");
        ptEstojos.setCtaTitle(
                "Transforme a Volta às Aulas em um Momento Especial");
        ptEstojos.setCtaDescription(
                "Um estojo personalizado faz toda a diferença. Imagine o sorriso do seu filho ao receber um estojo único, com seu personagem favorito e seu nome. Faça da organização escolar algo divertido e especial!");
        ptEstojos.setCtaAttention(
                "⚡ ATENÇÃO: Garanta já o estojo personalizado do seu filho antes do início das aulas! Faça o pedido com antecedência para receber a tempo.");
        ptEstojos.setCtaButtonText(
                "✨ SIM! Quero Meu Estojo Personalizado");
        ptEstojos.setHeroTitle(
                "Estojos que Encantam e Organizam com Estilo");
        ptEstojos.setHeroButtonText(
                "💝 Criar Meu Estojo");
        ptEstojos.setGaleriaTitle(
                "Crianças Felizes, Pais Satisfeitos");
        ptEstojos.setGaleriaDescricao(
                "Veja o que as famílias estão dizendo sobre nossos estojos personalizados. Cada sorriso é uma criança mais organizada e feliz com seu material escolar!");

// 3. Crie a tradução para Inglês (en)
        CategoriaTranslation enEstojos = new CategoriaTranslation();

        enEstojos.setLocale(
                "en");
        enEstojos.setCategoria(estojos);

        enEstojos.setNomeSingular(
                "Pencil Case");
        enEstojos.setNomePlural(
                "Custom Pencil Cases");
        enEstojos.setDescricao(
                "Custom pencil cases that delight children and organize school supplies with style and personality.");
        enEstojos.setCtaTitle(
                "Make Back to School a Special Moment");
        enEstojos.setCtaDescription(
                "A custom pencil case makes all the difference. Imagine your child's smile upon receiving a unique case with their favorite character and name. Make school organization fun and special!");
        enEstojos.setCtaAttention(
                "⚡ ATTENTION: Secure your child's custom pencil case before school starts! Order in advance to receive it on time.");
        enEstojos.setCtaButtonText(
                "✨ YES! I Want My Custom Pencil Case");
        enEstojos.setHeroTitle(
                "Pencil Cases that Delight and Organize with Style");
        enEstojos.setHeroButtonText(
                "💝 Create My Pencil Case");
        enEstojos.setGaleriaTitle(
                "Happy Children, Satisfied Parents");
        enEstojos.setGaleriaDescricao(
                "See what families are saying about our personalized pencil cases. Each smile is a happier, more organized child!");
// 4. Adicione as traduções à categoria e salve
        estojos.getTranslations()
                .addAll(Arrays.asList(ptEstojos, enEstojos));
        categoriaRepository.save(estojos);

        // --- Produtos para a categoria Estojos (CORRIGIDO) ---
// Produto 1
        Produto estojo1 = new Produto("/images/Produtos/Estojo/960x640 Estojo e Mochila.png", estojos);
        ProdutoTranslation ptEstojo1 = new ProdutoTranslation();

        ptEstojo1.setLocale(
                "pt-BR");
        ptEstojo1.setNome(
                "Conjuntos Coordenados");
        ptEstojo1.setDescricao(
                "Estojos e mochilas que combinam para um visual completo e organizado.");
        ptEstojo1.setProduto(estojo1);
        ProdutoTranslation enEstojo1 = new ProdutoTranslation();

        enEstojo1.setLocale(
                "en");
        enEstojo1.setNome(
                "Coordinated Sets");
        enEstojo1.setDescricao(
                "Pencil cases and backpacks that match for a complete and organized look.");
        enEstojo1.setProduto(estojo1);

        estojo1.getTranslations()
                .addAll(Arrays.asList(ptEstojo1, enEstojo1));
        produtoRepository.save(estojo1);

// Produto 2
        Produto estojo2 = new Produto("/images/Produtos/Estojo/960x640 Estojo Homem Aranha.png", estojos);
        ProdutoTranslation ptEstojo2 = new ProdutoTranslation();

        ptEstojo2.setLocale(
                "pt-BR");
        ptEstojo2.setNome(
                "Heróis Favoritos");
        ptEstojo2.setDescricao(
                "Personagens que inspiram e acompanham seu filho todos os dias.");
        ptEstojo2.setProduto(estojo2);
        ProdutoTranslation enEstojo2 = new ProdutoTranslation();

        enEstojo2.setLocale(
                "en");
        enEstojo2.setNome(
                "Favorite Heroes");
        enEstojo2.setDescricao(
                "Characters that inspire and accompany your child every day.");
        enEstojo2.setProduto(estojo2);

        estojo2.getTranslations()
                .addAll(Arrays.asList(ptEstojo2, enEstojo2));
        produtoRepository.save(estojo2);

// Produto 3
        Produto estojo3 = new Produto("/images/Produtos/Estojo/960x640 Abelhinas.png", estojos);
        ProdutoTranslation ptEstojo3 = new ProdutoTranslation();

        ptEstojo3.setLocale(
                "pt-BR");
        ptEstojo3.setNome(
                "Designs Divertidos");
        ptEstojo3.setDescricao(
                "Formatos criativos que trazem alegria para a rotina escolar.");
        ptEstojo3.setProduto(estojo3);
        ProdutoTranslation enEstojo3 = new ProdutoTranslation();

        enEstojo3.setLocale(
                "en");
        enEstojo3.setNome(
                "Fun Designs");
        enEstojo3.setDescricao(
                "Creative shapes that bring joy to the school routine.");
        enEstojo3.setProduto(estojo3);

        estojo3.getTranslations()
                .addAll(Arrays.asList(ptEstojo3, enEstojo3));
        produtoRepository.save(estojo3);

// Produto 4
        Produto estojo4 = new Produto("/images/Produtos/Estojo/960x640 Estojo Oculos.png", estojos);
        ProdutoTranslation ptEstojo4 = new ProdutoTranslation();

        ptEstojo4.setLocale(
                "pt-BR");
        ptEstojo4.setNome(
                "Proteção para Óculos");
        ptEstojo4.setDescricao(
                "Estojos especiais que protegem os óculos com estilo e segurança.");
        ptEstojo4.setProduto(estojo4);
        ProdutoTranslation enEstojo4 = new ProdutoTranslation();

        enEstojo4.setLocale(
                "en");
        enEstojo4.setNome(
                "Protection for Glasses");
        enEstojo4.setDescricao(
                "Special cases that protect glasses with style and security.");
        enEstojo4.setProduto(estojo4);

        estojo4.getTranslations()
                .addAll(Arrays.asList(ptEstojo4, enEstojo4));
        produtoRepository.save(estojo4);

// Produto 5
        Produto estojo5 = new Produto("/images/Produtos/Estojo/960x640 Estojo Ady.png", estojos);
        ProdutoTranslation ptEstojo5 = new ProdutoTranslation();

        ptEstojo5.setLocale(
                "pt-BR");
        ptEstojo5.setNome(
                "Nomes Personalizados");
        ptEstojo5.setDescricao(
                "Estojos únicos com o nome do seu filho, evitando trocas e perdas.");
        ptEstojo5.setProduto(estojo5);
        ProdutoTranslation enEstojo5 = new ProdutoTranslation();

        enEstojo5.setLocale(
                "en");
        enEstojo5.setNome(
                "Custom Names");
        enEstojo5.setDescricao(
                "Unique cases with your child's name, preventing mix-ups and loss.");
        enEstojo5.setProduto(estojo5);

        estojo5.getTranslations()
                .addAll(Arrays.asList(ptEstojo5, enEstojo5));
        produtoRepository.save(estojo5);

// Produto 6
        Produto estojo6 = new Produto("/images/Produtos/Estojo/960x640 Estojo Gatinhos.png", estojos);
        ProdutoTranslation ptEstojo6 = new ProdutoTranslation();

        ptEstojo6.setLocale(
                "pt-BR");
        ptEstojo6.setNome(
                "Estampas Exclusivas");
        ptEstojo6.setDescricao(
                "Padrões únicos que combinam com a personalidade de cada criança.");
        ptEstojo6.setProduto(estojo6);
        ProdutoTranslation enEstojo6 = new ProdutoTranslation();

        enEstojo6.setLocale(
                "en");
        enEstojo6.setNome(
                "Exclusive Prints");
        enEstojo6.setDescricao(
                "Unique patterns that match each child's personality.");
        enEstojo6.setProduto(estojo6);

        estojo6.getTranslations()
                .addAll(Arrays.asList(ptEstojo6, enEstojo6));
        produtoRepository.save(estojo6);
        // --- TIPOS DE PERSONALIZAÇÃO PARA A CATEGORIA 'ESTOJOS' (CORRIGIDO) ---
        TipoPersonalizacao tipoEstojo1 = new TipoPersonalizacao();

        tipoEstojo1.setNomeIcone(
                "heart");
        tipoEstojo1.setCategoria(estojos);
        TipoPersonalizacaoTranslation ptTransE1 = new TipoPersonalizacaoTranslation();

        ptTransE1.setLocale(
                "pt-BR");
        ptTransE1.setTitulo(
                "Animais e Bichinhos");
        ptTransE1.setTipoPersonalizacao(tipoEstojo1);
        TipoPersonalizacaoTranslation enTransE1 = new TipoPersonalizacaoTranslation();

        enTransE1.setLocale(
                "en");
        enTransE1.setTitulo(
                "Animals & Critters");
        enTransE1.setTipoPersonalizacao(tipoEstojo1);

        tipoEstojo1.getTranslations()
                .addAll(Arrays.asList(ptTransE1, enTransE1));
        // --- Itens para "Animais e Bichinhos" com tradução ---

// Item 1
        ItemPersonalizacao itemE1_1 = new ItemPersonalizacao();

        itemE1_1.setTipoPersonalizacao(tipoEstojo1);
        ItemPersonalizacaoTranslation ptItemE1_1 = new ItemPersonalizacaoTranslation();

        ptItemE1_1.setLocale(
                "pt-BR");
        ptItemE1_1.setTexto(
                "Estojos em formato de animais fofos");
        ptItemE1_1.setItemPersonalizacao(itemE1_1);
        ItemPersonalizacaoTranslation enItemE1_1 = new ItemPersonalizacaoTranslation();

        enItemE1_1.setLocale(
                "en");
        enItemE1_1.setTexto(
                "Cute animal-shaped pencil cases");
        enItemE1_1.setItemPersonalizacao(itemE1_1);

        itemE1_1.getTranslations()
                .addAll(Arrays.asList(ptItemE1_1, enItemE1_1));
        tipoEstojo1.getItens()
                .add(itemE1_1);

// Item 2
        ItemPersonalizacao itemE1_2 = new ItemPersonalizacao();

        itemE1_2.setTipoPersonalizacao(tipoEstojo1);
        ItemPersonalizacaoTranslation ptItemE1_2 = new ItemPersonalizacaoTranslation();

        ptItemE1_2.setLocale(
                "pt-BR");
        ptItemE1_2.setTexto(
                "Estampas com pets e bichinhos");
        ptItemE1_2.setItemPersonalizacao(itemE1_2);
        ItemPersonalizacaoTranslation enItemE1_2 = new ItemPersonalizacaoTranslation();

        enItemE1_2.setLocale(
                "en");
        enItemE1_2.setTexto(
                "Prints with pets and critters");
        enItemE1_2.setItemPersonalizacao(itemE1_2);

        itemE1_2.getTranslations()
                .addAll(Arrays.asList(ptItemE1_2, enItemE1_2));
        tipoEstojo1.getItens()
                .add(itemE1_2);

// Item 3
        ItemPersonalizacao itemE1_3 = new ItemPersonalizacao();

        itemE1_3.setTipoPersonalizacao(tipoEstojo1);
        ItemPersonalizacaoTranslation ptItemE1_3 = new ItemPersonalizacaoTranslation();

        ptItemE1_3.setLocale(
                "pt-BR");
        ptItemE1_3.setTexto(
                "Designs com animais da floresta");
        ptItemE1_3.setItemPersonalizacao(itemE1_3);
        ItemPersonalizacaoTranslation enItemE1_3 = new ItemPersonalizacaoTranslation();

        enItemE1_3.setLocale(
                "en");
        enItemE1_3.setTexto(
                "Designs with forest animals");
        enItemE1_3.setItemPersonalizacao(itemE1_3);

        itemE1_3.getTranslations()
                .addAll(Arrays.asList(ptItemE1_3, enItemE1_3));
        tipoEstojo1.getItens()
                .add(itemE1_3);

// Item 4
        ItemPersonalizacao itemE1_4 = new ItemPersonalizacao();

        itemE1_4.setTipoPersonalizacao(tipoEstojo1);
        ItemPersonalizacaoTranslation ptItemE1_4 = new ItemPersonalizacaoTranslation();

        ptItemE1_4.setLocale(
                "pt-BR");
        ptItemE1_4.setTexto(
                "Padrões com dinossauros");
        ptItemE1_4.setItemPersonalizacao(itemE1_4);
        ItemPersonalizacaoTranslation enItemE1_4 = new ItemPersonalizacaoTranslation();

        enItemE1_4.setLocale(
                "en");
        enItemE1_4.setTexto(
                "Patterns with dinosaurs");
        enItemE1_4.setItemPersonalizacao(itemE1_4);

        itemE1_4.getTranslations()
                .addAll(Arrays.asList(ptItemE1_4, enItemE1_4));
        tipoEstojo1.getItens()
                .add(itemE1_4);

// Item 5
        ItemPersonalizacao itemE1_5 = new ItemPersonalizacao();

        itemE1_5.setTipoPersonalizacao(tipoEstojo1);
        ItemPersonalizacaoTranslation ptItemE1_5 = new ItemPersonalizacaoTranslation();

        ptItemE1_5.setLocale(
                "pt-BR");
        ptItemE1_5.setTexto(
                "Temas marinhos com peixinhos");
        ptItemE1_5.setItemPersonalizacao(itemE1_5);
        ItemPersonalizacaoTranslation enItemE1_5 = new ItemPersonalizacaoTranslation();

        enItemE1_5.setLocale(
                "en");
        enItemE1_5.setTexto(
                "Marine themes with little fish");
        enItemE1_5.setItemPersonalizacao(itemE1_5);

        itemE1_5.getTranslations()
                .addAll(Arrays.asList(ptItemE1_5, enItemE1_5));
        tipoEstojo1.getItens()
                .add(itemE1_5);

        TipoPersonalizacao tipoEstojo2 = new TipoPersonalizacao();

        tipoEstojo2.setNomeIcone(
                "tv");
        tipoEstojo2.setCategoria(estojos);
        TipoPersonalizacaoTranslation ptTransE2 = new TipoPersonalizacaoTranslation();

        ptTransE2.setLocale(
                "pt-BR");
        ptTransE2.setTitulo(
                "Personagens Favoritos");
        ptTransE2.setTipoPersonalizacao(tipoEstojo2);
        TipoPersonalizacaoTranslation enTransE2 = new TipoPersonalizacaoTranslation();

        enTransE2.setLocale(
                "en");
        enTransE2.setTitulo(
                "Favorite Characters");
        enTransE2.setTipoPersonalizacao(tipoEstojo2);

        tipoEstojo2.getTranslations()
                .addAll(Arrays.asList(ptTransE2, enTransE2));
        // --- Itens para "Personagens Favoritos" com tradução ---

// Item 1
        ItemPersonalizacao itemE2_1 = new ItemPersonalizacao();

        itemE2_1.setTipoPersonalizacao(tipoEstojo2);
        ItemPersonalizacaoTranslation ptItemE2_1 = new ItemPersonalizacaoTranslation();

        ptItemE2_1.setLocale(
                "pt-BR");
        ptItemE2_1.setTexto(
                "Super-heróis (Homem-Aranha, Batman)");
        ptItemE2_1.setItemPersonalizacao(itemE2_1);
        ItemPersonalizacaoTranslation enItemE2_1 = new ItemPersonalizacaoTranslation();

        enItemE2_1.setLocale(
                "en");
        enItemE2_1.setTexto(
                "Superheroes (Spider-Man, Batman)");
        enItemE2_1.setItemPersonalizacao(itemE2_1);

        itemE2_1.getTranslations()
                .addAll(Arrays.asList(ptItemE2_1, enItemE2_1));
        tipoEstojo2.getItens()
                .add(itemE2_1);

// Item 2
        ItemPersonalizacao itemE2_2 = new ItemPersonalizacao();

        itemE2_2.setTipoPersonalizacao(tipoEstojo2);
        ItemPersonalizacaoTranslation ptItemE2_2 = new ItemPersonalizacaoTranslation();

        ptItemE2_2.setLocale(
                "pt-BR");
        ptItemE2_2.setTexto(
                "Princesas e personagens Disney");
        ptItemE2_2.setItemPersonalizacao(itemE2_2);
        ItemPersonalizacaoTranslation enItemE2_2 = new ItemPersonalizacaoTranslation();

        enItemE2_2.setLocale(
                "en");
        enItemE2_2.setTexto(
                "Princesses and Disney characters");
        enItemE2_2.setItemPersonalizacao(itemE2_2);

        itemE2_2.getTranslations()
                .addAll(Arrays.asList(ptItemE2_2, enItemE2_2));
        tipoEstojo2.getItens()
                .add(itemE2_2);

// Item 3
        ItemPersonalizacao itemE2_3 = new ItemPersonalizacao();

        itemE2_3.setTipoPersonalizacao(tipoEstojo2);
        ItemPersonalizacaoTranslation ptItemE2_3 = new ItemPersonalizacaoTranslation();

        ptItemE2_3.setLocale(
                "pt-BR");
        ptItemE2_3.setTexto(
                "Personagens de desenhos animados");
        ptItemE2_3.setItemPersonalizacao(itemE2_3);
        ItemPersonalizacaoTranslation enItemE2_3 = new ItemPersonalizacaoTranslation();

        enItemE2_3.setLocale(
                "en");
        enItemE2_3.setTexto(
                "Cartoon characters");
        enItemE2_3.setItemPersonalizacao(itemE2_3);

        itemE2_3.getTranslations()
                .addAll(Arrays.asList(ptItemE2_3, enItemE2_3));
        tipoEstojo2.getItens()
                .add(itemE2_3);

// Item 4
        ItemPersonalizacao itemE2_4 = new ItemPersonalizacao();

        itemE2_4.setTipoPersonalizacao(tipoEstojo2);
        ItemPersonalizacaoTranslation ptItemE2_4 = new ItemPersonalizacaoTranslation();

        ptItemE2_4.setLocale(
                "pt-BR");
        ptItemE2_4.setTexto(
                "Jogos populares como Minecraft e Roblox");
        ptItemE2_4.setItemPersonalizacao(itemE2_4);
        ItemPersonalizacaoTranslation enItemE2_4 = new ItemPersonalizacaoTranslation();

        enItemE2_4.setLocale(
                "en");
        enItemE2_4.setTexto(
                "Popular games like Minecraft and Roblox");
        enItemE2_4.setItemPersonalizacao(itemE2_4);

        itemE2_4.getTranslations()
                .addAll(Arrays.asList(ptItemE2_4, enItemE2_4));
        tipoEstojo2.getItens()
                .add(itemE2_4);

// Item 5
        ItemPersonalizacao itemE2_5 = new ItemPersonalizacao();

        itemE2_5.setTipoPersonalizacao(tipoEstojo2);
        ItemPersonalizacaoTranslation ptItemE2_5 = new ItemPersonalizacaoTranslation();

        ptItemE2_5.setLocale(
                "pt-BR");
        ptItemE2_5.setTexto(
                "Animes e mangás para os mais velhos");
        ptItemE2_5.setItemPersonalizacao(itemE2_5);
        ItemPersonalizacaoTranslation enItemE2_5 = new ItemPersonalizacaoTranslation();

        enItemE2_5.setLocale(
                "en");
        enItemE2_5.setTexto(
                "Anime and manga for older kids");
        enItemE2_5.setItemPersonalizacao(itemE2_5);

        itemE2_5.getTranslations()
                .addAll(Arrays.asList(ptItemE2_5, enItemE2_5));
        tipoEstojo2.getItens()
                .add(itemE2_5);

        TipoPersonalizacao tipoEstojo3 = new TipoPersonalizacao();

        tipoEstojo3.setNomeIcone(
                "star");
        tipoEstojo3.setCategoria(estojos);
        TipoPersonalizacaoTranslation ptTransE3 = new TipoPersonalizacaoTranslation();

        ptTransE3.setLocale(
                "pt-BR");
        ptTransE3.setTitulo(
                "Temas Mágicos");
        ptTransE3.setTipoPersonalizacao(tipoEstojo3);
        TipoPersonalizacaoTranslation enTransE3 = new TipoPersonalizacaoTranslation();

        enTransE3.setLocale(
                "en");
        enTransE3.setTitulo(
                "Magical Themes");
        enTransE3.setTipoPersonalizacao(tipoEstojo3);

        tipoEstojo3.getTranslations()
                .addAll(Arrays.asList(ptTransE3, enTransE3));
        // --- Itens para "Temas Mágicos" com tradução ---

// Item 1
        ItemPersonalizacao itemE3_1 = new ItemPersonalizacao();

        itemE3_1.setTipoPersonalizacao(tipoEstojo3);
        ItemPersonalizacaoTranslation ptItemE3_1 = new ItemPersonalizacaoTranslation();

        ptItemE3_1.setLocale(
                "pt-BR");
        ptItemE3_1.setTexto(
                "Unicórnios e arco-íris");
        ptItemE3_1.setItemPersonalizacao(itemE3_1);
        ItemPersonalizacaoTranslation enItemE3_1 = new ItemPersonalizacaoTranslation();

        enItemE3_1.setLocale(
                "en");
        enItemE3_1.setTexto(
                "Unicorns and rainbows");
        enItemE3_1.setItemPersonalizacao(itemE3_1);

        itemE3_1.getTranslations()
                .addAll(Arrays.asList(ptItemE3_1, enItemE3_1));
        tipoEstojo3.getItens()
                .add(itemE3_1);

// Item 2
        ItemPersonalizacao itemE3_2 = new ItemPersonalizacao();

        itemE3_2.setTipoPersonalizacao(tipoEstojo3);
        ItemPersonalizacaoTranslation ptItemE3_2 = new ItemPersonalizacaoTranslation();

        ptItemE3_2.setLocale(
                "pt-BR");
        ptItemE3_2.setTexto(
                "Fadas e elementos mágicos");
        ptItemE3_2.setItemPersonalizacao(itemE3_2);
        ItemPersonalizacaoTranslation enItemE3_2 = new ItemPersonalizacaoTranslation();

        enItemE3_2.setLocale(
                "en");
        enItemE3_2.setTexto(
                "Fairies and magical elements");
        enItemE3_2.setItemPersonalizacao(itemE3_2);

        itemE3_2.getTranslations()
                .addAll(Arrays.asList(ptItemE3_2, enItemE3_2));
        tipoEstojo3.getItens()
                .add(itemE3_2);

// Item 3
        ItemPersonalizacao itemE3_3 = new ItemPersonalizacao();

        itemE3_3.setTipoPersonalizacao(tipoEstojo3);
        ItemPersonalizacaoTranslation ptItemE3_3 = new ItemPersonalizacaoTranslation();

        ptItemE3_3.setLocale(
                "pt-BR");
        ptItemE3_3.setTexto(
                "Espaço e planetas");
        ptItemE3_3.setItemPersonalizacao(itemE3_3);
        ItemPersonalizacaoTranslation enItemE3_3 = new ItemPersonalizacaoTranslation();

        enItemE3_3.setLocale(
                "en");
        enItemE3_3.setTexto(
                "Space and planets");
        enItemE3_3.setItemPersonalizacao(itemE3_3);

        itemE3_3.getTranslations()
                .addAll(Arrays.asList(ptItemE3_3, enItemE3_3));
        tipoEstojo3.getItens()
                .add(itemE3_3);

// Item 4
        ItemPersonalizacao itemE3_4 = new ItemPersonalizacao();

        itemE3_4.setTipoPersonalizacao(tipoEstojo3);
        ItemPersonalizacaoTranslation ptItemE3_4 = new ItemPersonalizacaoTranslation();

        ptItemE3_4.setLocale(
                "pt-BR");
        ptItemE3_4.setTexto(
                "Sereias e criaturas míticas");
        ptItemE3_4.setItemPersonalizacao(itemE3_4);
        ItemPersonalizacaoTranslation enItemE3_4 = new ItemPersonalizacaoTranslation();

        enItemE3_4.setLocale(
                "en");
        enItemE3_4.setTexto(
                "Mermaids and mythical creatures");
        enItemE3_4.setItemPersonalizacao(itemE3_4);

        itemE3_4.getTranslations()
                .addAll(Arrays.asList(ptItemE3_4, enItemE3_4));
        tipoEstojo3.getItens()
                .add(itemE3_4);

// Item 5
        ItemPersonalizacao itemE3_5 = new ItemPersonalizacao();

        itemE3_5.setTipoPersonalizacao(tipoEstojo3);
        ItemPersonalizacaoTranslation ptItemE3_5 = new ItemPersonalizacaoTranslation();

        ptItemE3_5.setLocale(
                "pt-BR");
        ptItemE3_5.setTexto(
                "Dragões e castelos");
        ptItemE3_5.setItemPersonalizacao(itemE3_5);
        ItemPersonalizacaoTranslation enItemE3_5 = new ItemPersonalizacaoTranslation();

        enItemE3_5.setLocale(
                "en");
        enItemE3_5.setTexto(
                "Dragons and castles");
        enItemE3_5.setItemPersonalizacao(itemE3_5);

        itemE3_5.getTranslations()
                .addAll(Arrays.asList(ptItemE3_5, enItemE3_5));
        tipoEstojo3.getItens()
                .add(itemE3_5);

        TipoPersonalizacao tipoEstojo4 = new TipoPersonalizacao();

        tipoEstojo4.setNomeIcone(
                "gamepad-2");
        tipoEstojo4.setCategoria(estojos);
        TipoPersonalizacaoTranslation ptTransE4 = new TipoPersonalizacaoTranslation();

        ptTransE4.setLocale(
                "pt-BR");
        ptTransE4.setTitulo(
                "Hobbies e Esportes");
        ptTransE4.setTipoPersonalizacao(tipoEstojo4);
        TipoPersonalizacaoTranslation enTransE4 = new TipoPersonalizacaoTranslation();

        enTransE4.setLocale(
                "en");
        enTransE4.setTitulo(
                "Hobbies & Sports");
        enTransE4.setTipoPersonalizacao(tipoEstojo4);

        tipoEstojo4.getTranslations()
                .addAll(Arrays.asList(ptTransE4, enTransE4));
        // --- Itens para "Hobbies e Esportes" com tradução ---

// Item 1
        ItemPersonalizacao itemE4_1 = new ItemPersonalizacao();

        itemE4_1.setTipoPersonalizacao(tipoEstojo4);
        ItemPersonalizacaoTranslation ptItemE4_1 = new ItemPersonalizacaoTranslation();

        ptItemE4_1.setLocale(
                "pt-BR");
        ptItemE4_1.setTexto(
                "Futebol e times favoritos");
        ptItemE4_1.setItemPersonalizacao(itemE4_1);
        ItemPersonalizacaoTranslation enItemE4_1 = new ItemPersonalizacaoTranslation();

        enItemE4_1.setLocale(
                "en");
        enItemE4_1.setTexto(
                "Soccer and favorite teams");
        enItemE4_1.setItemPersonalizacao(itemE4_1);

        itemE4_1.getTranslations()
                .addAll(Arrays.asList(ptItemE4_1, enItemE4_1));
        tipoEstojo4.getItens()
                .add(itemE4_1);

// Item 2
        ItemPersonalizacao itemE4_2 = new ItemPersonalizacao();

        itemE4_2.setTipoPersonalizacao(tipoEstojo4);
        ItemPersonalizacaoTranslation ptItemE4_2 = new ItemPersonalizacaoTranslation();

        ptItemE4_2.setLocale(
                "pt-BR");
        ptItemE4_2.setTexto(
                "Ballet e dança");
        ptItemE4_2.setItemPersonalizacao(itemE4_2);
        ItemPersonalizacaoTranslation enItemE4_2 = new ItemPersonalizacaoTranslation();

        enItemE4_2.setLocale(
                "en");
        enItemE4_2.setTexto(
                "Ballet and dance");
        enItemE4_2.setItemPersonalizacao(itemE4_2);

        itemE4_2.getTranslations()
                .addAll(Arrays.asList(ptItemE4_2, enItemE4_2));
        tipoEstojo4.getItens()
                .add(itemE4_2);

// Item 3
        ItemPersonalizacao itemE4_3 = new ItemPersonalizacao();

        itemE4_3.setTipoPersonalizacao(tipoEstojo4);
        ItemPersonalizacaoTranslation ptItemE4_3 = new ItemPersonalizacaoTranslation();

        ptItemE4_3.setLocale(
                "pt-BR");
        ptItemE4_3.setTexto(
                "Instrumentos musicais");
        ptItemE4_3.setItemPersonalizacao(itemE4_3);
        ItemPersonalizacaoTranslation enItemE4_3 = new ItemPersonalizacaoTranslation();

        enItemE4_3.setLocale(
                "en");
        enItemE4_3.setTexto(
                "Musical instruments");
        enItemE4_3.setItemPersonalizacao(itemE4_3);

        itemE4_3.getTranslations()
                .addAll(Arrays.asList(ptItemE4_3, enItemE4_3));
        tipoEstojo4.getItens()
                .add(itemE4_3);

// Item 4
        ItemPersonalizacao itemE4_4 = new ItemPersonalizacao();

        itemE4_4.setTipoPersonalizacao(tipoEstojo4);
        ItemPersonalizacaoTranslation ptItemE4_4 = new ItemPersonalizacaoTranslation();

        ptItemE4_4.setLocale(
                "pt-BR");
        ptItemE4_4.setTexto(
                "Skate e esportes radicais");
        ptItemE4_4.setItemPersonalizacao(itemE4_4);
        ItemPersonalizacaoTranslation enItemE4_4 = new ItemPersonalizacaoTranslation();

        enItemE4_4.setLocale(
                "en");
        enItemE4_4.setTexto(
                "Skateboarding and extreme sports");
        enItemE4_4.setItemPersonalizacao(itemE4_4);

        itemE4_4.getTranslations()
                .addAll(Arrays.asList(ptItemE4_4, enItemE4_4));
        tipoEstojo4.getItens()
                .add(itemE4_4);

// Item 5
        ItemPersonalizacao itemE4_5 = new ItemPersonalizacao();

        itemE4_5.setTipoPersonalizacao(tipoEstojo4);
        ItemPersonalizacaoTranslation ptItemE4_5 = new ItemPersonalizacaoTranslation();

        ptItemE4_5.setLocale(
                "pt-BR");
        ptItemE4_5.setTexto(
                "Videogames e controles");
        ptItemE4_5.setItemPersonalizacao(itemE4_5);
        ItemPersonalizacaoTranslation enItemE4_5 = new ItemPersonalizacaoTranslation();

        enItemE4_5.setLocale(
                "en");
        enItemE4_5.setTexto(
                "Video games and controllers");
        enItemE4_5.setItemPersonalizacao(itemE4_5);

        itemE4_5.getTranslations()
                .addAll(Arrays.asList(ptItemE4_5, enItemE4_5));
        tipoEstojo4.getItens()
                .add(itemE4_5);

        TipoPersonalizacao tipoEstojo5 = new TipoPersonalizacao();

        tipoEstojo5.setNomeIcone(
                "text");
        tipoEstojo5.setCategoria(estojos);
        TipoPersonalizacaoTranslation ptTransE5 = new TipoPersonalizacaoTranslation();

        ptTransE5.setLocale(
                "pt-BR");
        ptTransE5.setTitulo(
                "Nomes e Iniciais");
        ptTransE5.setTipoPersonalizacao(tipoEstojo5);
        TipoPersonalizacaoTranslation enTransE5 = new TipoPersonalizacaoTranslation();

        enTransE5.setLocale(
                "en");
        enTransE5.setTitulo(
                "Names & Initials");
        enTransE5.setTipoPersonalizacao(tipoEstojo5);

        tipoEstojo5.getTranslations()
                .addAll(Arrays.asList(ptTransE5, enTransE5));
        // --- Itens para "Nomes e Iniciais" com tradução ---

// Item 1
        ItemPersonalizacao itemE5_1 = new ItemPersonalizacao();

        itemE5_1.setTipoPersonalizacao(tipoEstojo5);
        ItemPersonalizacaoTranslation ptItemE5_1 = new ItemPersonalizacaoTranslation();

        ptItemE5_1.setLocale(
                "pt-BR");
        ptItemE5_1.setTexto(
                "Nome completo em designs criativos");
        ptItemE5_1.setItemPersonalizacao(itemE5_1);
        ItemPersonalizacaoTranslation enItemE5_1 = new ItemPersonalizacaoTranslation();

        enItemE5_1.setLocale(
                "en");
        enItemE5_1.setTexto(
                "Full name in creative designs");
        enItemE5_1.setItemPersonalizacao(itemE5_1);

        itemE5_1.getTranslations()
                .addAll(Arrays.asList(ptItemE5_1, enItemE5_1));
        tipoEstojo5.getItens()
                .add(itemE5_1);

// Item 2
        ItemPersonalizacao itemE5_2 = new ItemPersonalizacao();

        itemE5_2.setTipoPersonalizacao(tipoEstojo5);
        ItemPersonalizacaoTranslation ptItemE5_2 = new ItemPersonalizacaoTranslation();

        ptItemE5_2.setLocale(
                "pt-BR");
        ptItemE5_2.setTexto(
                "Iniciais decoradas e estilizadas");
        ptItemE5_2.setItemPersonalizacao(itemE5_2);
        ItemPersonalizacaoTranslation enItemE5_2 = new ItemPersonalizacaoTranslation();

        enItemE5_2.setLocale(
                "en");
        enItemE5_2.setTexto(
                "Decorated and stylized initials");
        enItemE5_2.setItemPersonalizacao(itemE5_2);

        itemE5_2.getTranslations()
                .addAll(Arrays.asList(ptItemE5_2, enItemE5_2));
        tipoEstojo5.getItens()
                .add(itemE5_2);

// Item 3
        ItemPersonalizacao itemE5_3 = new ItemPersonalizacao();

        itemE5_3.setTipoPersonalizacao(tipoEstojo5);
        ItemPersonalizacaoTranslation ptItemE5_3 = new ItemPersonalizacaoTranslation();

        ptItemE5_3.setLocale(
                "pt-BR");
        ptItemE5_3.setTexto(
                "Apelidos carinhosos");
        ptItemE5_3.setItemPersonalizacao(itemE5_3);
        ItemPersonalizacaoTranslation enItemE5_3 = new ItemPersonalizacaoTranslation();

        enItemE5_3.setLocale(
                "en");
        enItemE5_3.setTexto(
                "Affectionate nicknames");
        enItemE5_3.setItemPersonalizacao(itemE5_3);

        itemE5_3.getTranslations()
                .addAll(Arrays.asList(ptItemE5_3, enItemE5_3));
        tipoEstojo5.getItens()
                .add(itemE5_3);

// Item 4
        ItemPersonalizacao itemE5_4 = new ItemPersonalizacao();

        itemE5_4.setTipoPersonalizacao(tipoEstojo5);
        ItemPersonalizacaoTranslation ptItemE5_4 = new ItemPersonalizacaoTranslation();

        ptItemE5_4.setLocale(
                "pt-BR");
        ptItemE5_4.setTexto(
                "Combinações com símbolos favoritos");
        ptItemE5_4.setItemPersonalizacao(itemE5_4);
        ItemPersonalizacaoTranslation enItemE5_4 = new ItemPersonalizacaoTranslation();

        enItemE5_4.setLocale(
                "en");
        enItemE5_4.setTexto(
                "Combinations with favorite symbols");
        enItemE5_4.setItemPersonalizacao(itemE5_4);

        itemE5_4.getTranslations()
                .addAll(Arrays.asList(ptItemE5_4, enItemE5_4));
        tipoEstojo5.getItens()
                .add(itemE5_4);

// Item 5
        ItemPersonalizacao itemE5_5 = new ItemPersonalizacao();

        itemE5_5.setTipoPersonalizacao(tipoEstojo5);
        ItemPersonalizacaoTranslation ptItemE5_5 = new ItemPersonalizacaoTranslation();

        ptItemE5_5.setLocale(
                "pt-BR");
        ptItemE5_5.setTexto(
                "Letras em diferentes estilos e fontes");
        ptItemE5_5.setItemPersonalizacao(itemE5_5);
        ItemPersonalizacaoTranslation enItemE5_5 = new ItemPersonalizacaoTranslation();

        enItemE5_5.setLocale(
                "en");
        enItemE5_5.setTexto(
                "Letters in different styles and fonts");
        enItemE5_5.setItemPersonalizacao(itemE5_5);

        itemE5_5.getTranslations()
                .addAll(Arrays.asList(ptItemE5_5, enItemE5_5));
        tipoEstojo5.getItens()
                .add(itemE5_5);

        TipoPersonalizacao tipoEstojo6 = new TipoPersonalizacao();

        tipoEstojo6.setNomeIcone(
                "sparkles");
        tipoEstojo6.setCategoria(estojos);
        TipoPersonalizacaoTranslation ptTransE6 = new TipoPersonalizacaoTranslation();

        ptTransE6.setLocale(
                "pt-BR");
        ptTransE6.setTitulo(
                "Estampas Exclusivas");
        ptTransE6.setTipoPersonalizacao(tipoEstojo6);
        TipoPersonalizacaoTranslation enTransE6 = new TipoPersonalizacaoTranslation();

        enTransE6.setLocale(
                "en");
        enTransE6.setTitulo(
                "Exclusive Prints");
        enTransE6.setTipoPersonalizacao(tipoEstojo6);

        tipoEstojo6.getTranslations()
                .addAll(Arrays.asList(ptTransE6, enTransE6));
        // --- Itens para "Estampas Exclusivas" com tradução ---

// Item 1
        ItemPersonalizacao itemE6_1 = new ItemPersonalizacao();

        itemE6_1.setTipoPersonalizacao(tipoEstojo6);
        ItemPersonalizacaoTranslation ptItemE6_1 = new ItemPersonalizacaoTranslation();

        ptItemE6_1.setLocale(
                "pt-BR");
        ptItemE6_1.setTexto(
                "Padrões geométricos coloridos");
        ptItemE6_1.setItemPersonalizacao(itemE6_1);
        ItemPersonalizacaoTranslation enItemE6_1 = new ItemPersonalizacaoTranslation();

        enItemE6_1.setLocale(
                "en");
        enItemE6_1.setTexto(
                "Colorful geometric patterns");
        enItemE6_1.setItemPersonalizacao(itemE6_1);

        itemE6_1.getTranslations()
                .addAll(Arrays.asList(ptItemE6_1, enItemE6_1));
        tipoEstojo6.getItens()
                .add(itemE6_1);

// Item 2
        ItemPersonalizacao itemE6_2 = new ItemPersonalizacao();

        itemE6_2.setTipoPersonalizacao(tipoEstojo6);
        ItemPersonalizacaoTranslation ptItemE6_2 = new ItemPersonalizacaoTranslation();

        ptItemE6_2.setLocale(
                "pt-BR");
        ptItemE6_2.setTexto(
                "Estampas tie-dye");
        ptItemE6_2.setItemPersonalizacao(itemE6_2);
        ItemPersonalizacaoTranslation enItemE6_2 = new ItemPersonalizacaoTranslation();

        enItemE6_2.setLocale(
                "en");
        enItemE6_2.setTexto(
                "Tie-dye prints");
        enItemE6_2.setItemPersonalizacao(itemE6_2);

        itemE6_2.getTranslations()
                .addAll(Arrays.asList(ptItemE6_2, enItemE6_2));
        tipoEstojo6.getItens()
                .add(itemE6_2);

// Item 3
        ItemPersonalizacao itemE6_3 = new ItemPersonalizacao();

        itemE6_3.setTipoPersonalizacao(tipoEstojo6);
        ItemPersonalizacaoTranslation ptItemE6_3 = new ItemPersonalizacaoTranslation();

        ptItemE6_3.setLocale(
                "pt-BR");
        ptItemE6_3.setTexto(
                "Galáxias e elementos cósmicos");
        ptItemE6_3.setItemPersonalizacao(itemE6_3);
        ItemPersonalizacaoTranslation enItemE6_3 = new ItemPersonalizacaoTranslation();

        enItemE6_3.setLocale(
                "en");
        enItemE6_3.setTexto(
                "Galaxies and cosmic elements");
        enItemE6_3.setItemPersonalizacao(itemE6_3);

        itemE6_3.getTranslations()
                .addAll(Arrays.asList(ptItemE6_3, enItemE6_3));
        tipoEstojo6.getItens()
                .add(itemE6_3);

// Item 4
        ItemPersonalizacao itemE6_4 = new ItemPersonalizacao();

        itemE6_4.setTipoPersonalizacao(tipoEstojo6);
        ItemPersonalizacaoTranslation ptItemE6_4 = new ItemPersonalizacaoTranslation();

        ptItemE6_4.setLocale(
                "pt-BR");
        ptItemE6_4.setTexto(
                "Flores e elementos da natureza");
        ptItemE6_4.setItemPersonalizacao(itemE6_4);
        ItemPersonalizacaoTranslation enItemE6_4 = new ItemPersonalizacaoTranslation();

        enItemE6_4.setLocale(
                "en");
        enItemE6_4.setTexto(
                "Flowers and nature elements");
        enItemE6_4.setItemPersonalizacao(itemE6_4);

        itemE6_4.getTranslations()
                .addAll(Arrays.asList(ptItemE6_4, enItemE6_4));
        tipoEstojo6.getItens()
                .add(itemE6_4);

// Item 5
        ItemPersonalizacao itemE6_5 = new ItemPersonalizacao();

        itemE6_5.setTipoPersonalizacao(tipoEstojo6);
        ItemPersonalizacaoTranslation ptItemE6_5 = new ItemPersonalizacaoTranslation();

        ptItemE6_5.setLocale(
                "pt-BR");
        ptItemE6_5.setTexto(
                "Estampas abstratas e artísticas");
        ptItemE6_5.setItemPersonalizacao(itemE6_5);
        ItemPersonalizacaoTranslation enItemE6_5 = new ItemPersonalizacaoTranslation();

        enItemE6_5.setLocale(
                "en");
        enItemE6_5.setTexto(
                "Abstract and artistic prints");
        enItemE6_5.setItemPersonalizacao(itemE6_5);

        itemE6_5.getTranslations()
                .addAll(Arrays.asList(ptItemE6_5, enItemE6_5));
        tipoEstojo6.getItens()
                .add(itemE6_5);

// Salva todos os tipos de personalização para 'Estojos' de uma vez
        tipoPersonalizacaoRepository.saveAll(Arrays.asList(tipoEstojo1, tipoEstojo2, tipoEstojo3, tipoEstojo4, tipoEstojo5, tipoEstojo6));
        // --- DEPOIMENTOS DA PÁGINA: Estojos.html ---
        Depoimento depEstojo1 = new Depoimento(
                "Tati Oliveira",
                "\"Meu filho ficou super empolgado com o estojo do Among Us! 🚀 Os personagens ficaram idênticos ao jogo! O zíper verde combinou perfeitamente com o tema. Ele não para de mostrar para os amigos! 😍\"",
                "/images/Produtos/Estojo/790x770 Estojo Among.png",
                estojos
        );

        Depoimento depEstojo2 = new Depoimento(
                "Ana Paula",
                "\"Os estojos de dinossauros do Bento ficaram perfeitos! 🦖 As cores vibrantes e os detalhes são incríveis! Meu filho adora os zíperes com os pingentes de dinossauros. Material super resistente para o dia a dia escolar! 🌟\"",
                "/images/Produtos/Estojo/790x770 Estojo Bento.png",
                estojos
        );

        Depoimento depEstojo3 = new Depoimento(
                "Agatha Mendes",
                "\"O estojo do Mickey ficou incrível! 🐭 Meu filho é apaixonado por quadrinhos e esse design em preto e branco com os detalhes coloridos ficou super estiloso. Ele é o mais animado da turma na hora de guardar os lápis! 📚\"",
                "/images/Produtos/Estojo/790x770 Estojo Mickey.png",
                estojos
        );

        Depoimento depEstojo4 = new Depoimento(
                "Luciana Consentino",
                "\"O kit de unicórnios é simplesmente mágico! 🦄✨ Minha filha ficou encantada com as carinhas fofas e as cores. O conjunto com três estojos diferentes ajuda muito na organização do material escolar. Qualidade incrível! 💕\"",
                "/images/Produtos/Estojo/790x770 Estojo Kit Unicornio.png",
                estojos
        );

        Depoimento depEstojo5 = new Depoimento(
                "Bruna Chanes",
                "\"A necessaire do Frozen ficou perfeita! Todos os personagens perfeitos. Minha filha amou que veio junto o nome dela, deixou ainda mais especial!🥰\"",
                "/images/Produtos/Estojo/790x770 Estojo Celsa Schimidtz.png",
                estojos
        );

        Depoimento depEstojo6 = new Depoimento(
                "Carla Medeiros",
                "\"O estojo do Bob Esponja fez o maior sucesso! 🍍 Meu filho adora todos os personagens e as cores vibrantes. O tamanho é perfeito para todos os lápis e canetas da escola. Ele não troca por nada! 🌊🧽\"",
                "/images/Produtos/Estojo/790x770 Estojo Bob Esponja.png",
                estojos
        );

        depoimentoRepository.saveAll(Arrays.asList(depEstojo1, depEstojo2, depEstojo3, depEstojo4, depEstojo5, depEstojo6));

    }

    // --- CATEGORIA MOCHILAS ---
    // --- CATEGORIA MOCHILAS ---
    private void criarCategoriaMochilas() {
        Categoria mochilas = new Categoria();
// 1. Defina os campos que NÃO são traduzidos

        mochilas.setSlug(
                "mochilas");
        mochilas.setImagemDestaqueUrl(
                "/images/Produtos/Mochila/800x800 Mochilas Animais.jpeg");
        mochilas.setUrlImagemPersonalizacao(
                "/images/Produtos/Mochila/800x800 Lancheira Frutas.png");
        mochilas.setImagemUrlHome(
                "/images/Home/420x260 Mochilas Home.png");

// 2. Crie a tradução para Português (pt-BR)
        CategoriaTranslation ptMochilas = new CategoriaTranslation();

        ptMochilas.setLocale(
                "pt-BR");
        ptMochilas.setCategoria(mochilas);

        ptMochilas.setNomeSingular(
                "Mochila");
        ptMochilas.setNomePlural(
                "Mochilas e Lancheiras");
        ptMochilas.setDescricao(
                "Transforme o dia a dia escolar do seu filho com mochilas e lancheiras 100% personalizadas. Cada peça é única, criada especialmente para refletir a personalidade da sua criança e tornar a ida à escola uma aventura incrível.");
        ptMochilas.setCtaTitle(
                "Prepare-se Para Aventura com Sua Mochila ou Lancheira Perfeita!");
        ptMochilas.setCtaDescription(
                "Sua mochila ou lancheira é mais que um acessório, é sua companheira de jornada. Crie uma peça única que reflita sua personalidade e organize suas aventuras com estilo. Do dia a dia à escola.");
        ptMochilas.setCtaAttention(
                "✨ Entrega em 3-7 dias • Material super resistente • Design divertido ✨");
        ptMochilas.setCtaButtonText(
                "✨ SIM! Quero Minha Mochila ou Lancheira Personalizada");
        ptMochilas.setHeroTitle(
                "Mochilas e Lancheiras que Fazem Cada Dia mais Divertido");
        ptMochilas.setHeroButtonText(
                "🎒 Criar a Mochila Perfeita");
        ptMochilas.setGaleriaTitle(
                "Mochilas e Lancheiras Com Os Temas Favoritos do Seu Filho");
        ptMochilas.setGaleriaDescricao(
                "Inspire-se com alguns modelos que já criamos! Aqui, cada mochila e lancheira é feita sob medida para o seu filho. Personalize do seu jeito: o tema, o nome, as cores e tudo mais!");

// 3. Crie a tradução para Inglês (en)
        CategoriaTranslation enMochilas = new CategoriaTranslation();

        enMochilas.setLocale(
                "en");
        enMochilas.setCategoria(mochilas);

        enMochilas.setNomeSingular(
                "Backpack");
        enMochilas.setNomePlural(
                "Backpacks & Lunch Boxes that Make Every Day More Fun");
        enMochilas.setDescricao(
                "Transform your child's school days with 100% custom backpacks and lunch boxes. Each piece is unique, specially created to reflect your child's personality and make going to school an amazing adventure.");
        enMochilas.setCtaTitle(
                "Get Ready for Adventure with Your Perfect Backpack or Lunch Box!");
        enMochilas.setCtaDescription(
                "Your backpack or lunch box is more than an accessory; it's your travel companion. Create a unique piece that reflects your personality and organizes your adventures with style. From daily life to school.");
        enMochilas.setCtaAttention(
                "✨ Delivery in 3-7 days • Super resistant material • Fun design ✨");
        enMochilas.setCtaButtonText(
                "✨ YES! I Want My Custom Backpack or Lunch Box");
        enMochilas.setHeroTitle(
                "Backpacks and Lunch Boxes that Make Every Day More Fun");
        enMochilas.setHeroButtonText(
                "🎒 Create the Perfect Backpack");
        enMochilas.setGaleriaTitle(
                "Backpacks and Lunch Boxes with Your Child's Favorite Themes");
        enMochilas.setGaleriaDescricao(
                "Get inspired by some models we've already created! Here, each backpack and lunch box is made to measure for your child. Personalize it your way: the theme, the name, the colors, and everything else!");

// 4. Adicione as traduções à categoria e salve
        mochilas.getTranslations()
                .addAll(Arrays.asList(ptMochilas, enMochilas));
        categoriaRepository.save(mochilas);
        // Produtos para a categoria Mochilas
        // Na seção de Mochilas, corrija os caminhos:
        // --- Produtos para a categoria Mochilas (CORRIGIDO) ---

// Produto 1 - Sereia
        Produto m1 = new Produto("/images/Produtos/Mochila/960x640 Mochila Rodinha Sereia.png", mochilas);
        ProdutoTranslation ptM1 = new ProdutoTranslation();

        ptM1.setLocale(
                "pt-BR");
        ptM1.setNome(
                "Para Pequenas Sereias Sonhadoras");
        ptM1.setDescricao(
                "Transforme o dia a dia escolar em um conto de fadas! Sereia, unicórnio ou o que imaginar: criamos do jeitinho que vocês quiserem!");
        ptM1.setProduto(m1);
        ProdutoTranslation enM1 = new ProdutoTranslation();

        enM1.setLocale(
                "en");
        enM1.setNome(
                "For Little Dreamer Mermaids");
        enM1.setDescricao(
                "Turn school days into a fairy tale! Mermaid, unicorn, or whatever you imagine: we create it just the way you want!");
        enM1.setProduto(m1);

        m1.getTranslations()
                .addAll(Arrays.asList(ptM1, enM1));
        produtoRepository.save(m1);

// Produto 2 - Lancheira Jesus
        Produto m2 = new Produto("/images/Produtos/Mochila/960x640 Lancheira Jesus.png", mochilas);
        ProdutoTranslation ptM2 = new ProdutoTranslation();

        ptM2.setLocale(
                "pt-BR");
        ptM2.setNome(
                "Fé e Carinho em Cada Lanche");
        ptM2.setDescricao(
                "Para famílias que querem levar proteção e amor para a escola. Ideal para quem valoriza fé e carinho no dia a dia.");
        ptM2.setProduto(m2);
        ProdutoTranslation enM2 = new ProdutoTranslation();

        enM2.setLocale(
                "en");
        enM2.setNome(
                "Faith and Care in Every Snack");
        enM2.setDescricao(
                "For families who want to bring protection and love to school. Perfect for those who value faith and care every day.");
        enM2.setProduto(m2);

        m2.getTranslations()
                .addAll(Arrays.asList(ptM2, enM2));
        produtoRepository.save(m2);

// Produto 3 - Capivara
        Produto m3 = new Produto("/images/Produtos/Mochila/960x640 Mochila Roda Capivara.png", mochilas);
        ProdutoTranslation ptM3 = new ProdutoTranslation();

        ptM3.setLocale(
                "pt-BR");
        ptM3.setNome(
                "Aventura com a Capivara Mais Fofa");
        ptM3.setDescricao(
                "A mochila perfeita para crianças que amam animais e querem se destacar! Com os animais mais fofos do Brasil, seu filho vai para a escola com muito estilo!");
        ptM3.setProduto(m3);
        ProdutoTranslation enM3 = new ProdutoTranslation();

        enM3.setLocale(
                "en");
        enM3.setNome(
                "Adventure with the Cutest Capybara");
        enM3.setDescricao(
                "The perfect backpack for kids who love animals and want to stand out! With the cutest animals from Brazil, your child goes to school in style!");
        enM3.setProduto(m3);

        m3.getTranslations()
                .addAll(Arrays.asList(ptM3, enM3));
        produtoRepository.save(m3);

// Produto 4 - Futebol
        Produto m4 = new Produto("/images/Produtos/Mochila/960x640 Lancheira Futebol.png", mochilas);
        ProdutoTranslation ptM4 = new ProdutoTranslation();

        ptM4.setLocale(
                "pt-BR");
        ptM4.setNome(
                "Para os Craques do Recreio");
        ptM4.setDescricao(
                "Futebol, esportes ou qualquer paixão: criamos lancheiras e mochilas para acompanhar toda a energia das crianças. Personalize do seu jeito!");
        ptM4.setProduto(m4);
        ProdutoTranslation enM4 = new ProdutoTranslation();

        enM4.setLocale(
                "en");
        enM4.setNome(
                "For the Playground Stars");
        enM4.setDescricao(
                "Soccer, sports, or any passion: we create lunch boxes and backpacks to match all the kids' energy. Personalize your way!");
        enM4.setProduto(m4);

        m4.getTranslations()
                .addAll(Arrays.asList(ptM4, enM4));
        produtoRepository.save(m4);

// Produto 5 - Kit Dinossauro
        Produto m5 = new Produto("/images/Produtos/Mochila/960x640 Mochila Kit Inteiro Dinossauro.png", mochilas);
        ProdutoTranslation ptM5 = new ProdutoTranslation();

        ptM5.setLocale(
                "pt-BR");
        ptM5.setNome(
                "Kit Dino: Diversão e Organização");
        ptM5.setDescricao(
                "O combo perfeito! Mochila, lancheira e estojo combinando, com detalhes que encantam! Seu filho vai adorar mostrar esse kit para os amigos e você vai amar a praticidade.");
        ptM5.setProduto(m5);
        ProdutoTranslation enM5 = new ProdutoTranslation();

        enM5.setLocale(
                "en");
        enM5.setNome(
                "Dino Kit: Fun and Organization");
        enM5.setDescricao(
                "The perfect combo! Backpack, lunch box, and pencil case matching, with charming details! Your child will love showing this kit to friends and you'll love the practicality.");
        enM5.setProduto(m5);

        m5.getTranslations()
                .addAll(Arrays.asList(ptM5, enM5));
        produtoRepository.save(m5);

// Produto 6 - Anime
        Produto m6 = new Produto("/images/Produtos/Mochila/960x640 Lancheira One Piece.png", mochilas);
        ProdutoTranslation ptM6 = new ProdutoTranslation();

        ptM6.setLocale(
                "pt-BR");
        ptM6.setNome(
                "Aventura de Anime Todo Dia");
        ptM6.setDescricao(
                "Anime, filmes, séries ou qualquer universo: transforme a mochila e lancheira em algo só dele com o nome do seu filho bordado!");
        ptM6.setProduto(m6);
        ProdutoTranslation enM6 = new ProdutoTranslation();

        enM6.setLocale(
                "en");
        enM6.setNome(
                "Anime Adventure Every Day");
        enM6.setDescricao(
                "Anime, movies, series, or any universe: turn the backpack and lunch box into something unique with your child's name embroidered!");
        enM6.setProduto(m6);

        m6.getTranslations()
                .addAll(Arrays.asList(ptM6, enM6));
        produtoRepository.save(m6);

        // Depoimento 1
        Depoimento dm1 = new Depoimento(
                "Renata",
                "Tenho três filhos e cada um escolheu um animal diferente. Quando chegaram, foi uma festa aqui em casa! Eles amaram tanto que até dormiram abraçados com as mochilas na primeira noite. Nunca vi eles tão animados para ir à escola!🥰",
                "/images/Produtos/Mochila/790x770 Mochila Turma dos Animais.png",
                mochilas
        );

        // Depoimento 2
        Depoimento dm2 = new Depoimento(
                "Juliana",
                "O Sonic sempre foi o desenho favorito do meu filho, então ver o brilho nos olhos dele ao receber a mochila foi inesquecível! Ele faz questão de mostrar para todo mundo na escola. A qualidade é incrível!",
                "/images/Produtos/Mochila/790x770 Mochila Sonic.png",
                mochilas
        );

        // Depoimento 3
        Depoimento dm3 = new Depoimento(
                "Camila",
                "Pedi o kit de unicórnio com a mochila, lancheira e estojo e minha filha amou! Agora todas as amigas querem igual e ela se sente super especial. Obrigada Tatiart! 🩷",
                "/images/Produtos/Mochila/790x770 Mochila Kit Unicornio.png",
                mochilas
        );

        depoimentoRepository.saveAll(Arrays.asList(dm1, dm2, dm3));

        // --- TIPOS DE PERSONALIZAÇÃO PARA A CATEGORIA 'MOCHILAS' (CORRIGIDO) ---
        TipoPersonalizacao tipoMochila1 = new TipoPersonalizacao();

        tipoMochila1.setNomeIcone(
                "heart");
        tipoMochila1.setCategoria(mochilas);
        TipoPersonalizacaoTranslation ptTransM1 = new TipoPersonalizacaoTranslation();

        ptTransM1.setLocale(
                "pt-BR");
        ptTransM1.setTitulo(
                "Pets e Animais");
        ptTransM1.setTipoPersonalizacao(tipoMochila1);
        TipoPersonalizacaoTranslation enTransM1 = new TipoPersonalizacaoTranslation();

        enTransM1.setLocale(
                "en");
        enTransM1.setTitulo(
                "Pets & Animals");
        enTransM1.setTipoPersonalizacao(tipoMochila1);

        tipoMochila1.getTranslations()
                .addAll(Arrays.asList(ptTransM1, enTransM1));
        // --- Itens para "Pets e Animais" com tradução ---

// Item 1
        ItemPersonalizacao itemM1_1 = new ItemPersonalizacao();

        itemM1_1.setTipoPersonalizacao(tipoMochila1);
        ItemPersonalizacaoTranslation ptItemM1_1 = new ItemPersonalizacaoTranslation();

        ptItemM1_1.setLocale(
                "pt-BR");
        ptItemM1_1.setTexto(
                "Fotos dos seus pets favoritos");
        ptItemM1_1.setItemPersonalizacao(itemM1_1);
        ItemPersonalizacaoTranslation enItemM1_1 = new ItemPersonalizacaoTranslation();

        enItemM1_1.setLocale(
                "en");
        enItemM1_1.setTexto(
                "Photos of your favorite pets");
        enItemM1_1.setItemPersonalizacao(itemM1_1);

        itemM1_1.getTranslations()
                .addAll(Arrays.asList(ptItemM1_1, enItemM1_1));
        tipoMochila1.getItens()
                .add(itemM1_1);

// Item 2
        ItemPersonalizacao itemM1_2 = new ItemPersonalizacao();

        itemM1_2.setTipoPersonalizacao(tipoMochila1);
        ItemPersonalizacaoTranslation ptItemM1_2 = new ItemPersonalizacaoTranslation();

        ptItemM1_2.setLocale(
                "pt-BR");
        ptItemM1_2.setTexto(
                "Ilustrações personalizadas dos bichinhos");
        ptItemM1_2.setItemPersonalizacao(itemM1_2);
        ItemPersonalizacaoTranslation enItemM1_2 = new ItemPersonalizacaoTranslation();

        enItemM1_2.setLocale(
                "en");
        enItemM1_2.setTexto(
                "Custom illustrations of the critters");
        enItemM1_2.setItemPersonalizacao(itemM1_2);

        itemM1_2.getTranslations()
                .addAll(Arrays.asList(ptItemM1_2, enItemM1_2));
        tipoMochila1.getItens()
                .add(itemM1_2);

// Item 3
        ItemPersonalizacao itemM1_3 = new ItemPersonalizacao();

        itemM1_3.setTipoPersonalizacao(tipoMochila1);
        ItemPersonalizacaoTranslation ptItemM1_3 = new ItemPersonalizacaoTranslation();

        ptItemM1_3.setLocale(
                "pt-BR");
        ptItemM1_3.setTexto(
                "Nomes e datas especiais");
        ptItemM1_3.setItemPersonalizacao(itemM1_3);
        ItemPersonalizacaoTranslation enItemM1_3 = new ItemPersonalizacaoTranslation();

        enItemM1_3.setLocale(
                "en");
        enItemM1_3.setTexto(
                "Special names and dates");
        enItemM1_3.setItemPersonalizacao(itemM1_3);

        itemM1_3.getTranslations()
                .addAll(Arrays.asList(ptItemM1_3, enItemM1_3));
        tipoMochila1.getItens()
                .add(itemM1_3);

// Item 4
        ItemPersonalizacao itemM1_4 = new ItemPersonalizacao();

        itemM1_4.setTipoPersonalizacao(tipoMochila1);
        ItemPersonalizacaoTranslation ptItemM1_4 = new ItemPersonalizacaoTranslation();

        ptItemM1_4.setLocale(
                "pt-BR");
        ptItemM1_4.setTexto(
                "Patinhas e símbolos fofos");
        ptItemM1_4.setItemPersonalizacao(itemM1_4);
        ItemPersonalizacaoTranslation enItemM1_4 = new ItemPersonalizacaoTranslation();

        enItemM1_4.setLocale(
                "en");
        enItemM1_4.setTexto(
                "Cute paws and symbols");
        enItemM1_4.setItemPersonalizacao(itemM1_4);

        itemM1_4.getTranslations()
                .addAll(Arrays.asList(ptItemM1_4, enItemM1_4));
        tipoMochila1.getItens()
                .add(itemM1_4);

// Item 5
        ItemPersonalizacao itemM1_5 = new ItemPersonalizacao();

        itemM1_5.setTipoPersonalizacao(tipoMochila1);
        ItemPersonalizacaoTranslation ptItemM1_5 = new ItemPersonalizacaoTranslation();

        ptItemM1_5.setLocale(
                "pt-BR");
        ptItemM1_5.setTexto(
                "Raças específicas e características únicas");
        ptItemM1_5.setItemPersonalizacao(itemM1_5);
        ItemPersonalizacaoTranslation enItemM1_5 = new ItemPersonalizacaoTranslation();

        enItemM1_5.setLocale(
                "en");
        enItemM1_5.setTexto(
                "Specific breeds and unique features");
        enItemM1_5.setItemPersonalizacao(itemM1_5);

        itemM1_5.getTranslations()
                .addAll(Arrays.asList(ptItemM1_5, enItemM1_5));
        tipoMochila1.getItens()
                .add(itemM1_5);

        TipoPersonalizacao tipoMochila2 = new TipoPersonalizacao();

        tipoMochila2.setNomeIcone(
                "briefcase");
        tipoMochila2.setCategoria(mochilas);
        TipoPersonalizacaoTranslation ptTransM2 = new TipoPersonalizacaoTranslation();

        ptTransM2.setLocale(
                "pt-BR");
        ptTransM2.setTitulo(
                "Profissões Especiais");
        ptTransM2.setTipoPersonalizacao(tipoMochila2);
        TipoPersonalizacaoTranslation enTransM2 = new TipoPersonalizacaoTranslation();

        enTransM2.setLocale(
                "en");
        enTransM2.setTitulo(
                "Special Professions");
        enTransM2.setTipoPersonalizacao(tipoMochila2);

        tipoMochila2.getTranslations()
                .addAll(Arrays.asList(ptTransM2, enTransM2));
        // --- Itens para "Profissões Especiais" com tradução ---

// Item 1
        ItemPersonalizacao itemM2_1 = new ItemPersonalizacao();

        itemM2_1.setTipoPersonalizacao(tipoMochila2);
        ItemPersonalizacaoTranslation ptItemM2_1 = new ItemPersonalizacaoTranslation();

        ptItemM2_1.setLocale(
                "pt-BR");
        ptItemM2_1.setTexto(
                "Médicas, enfermeiras e profissionais da saúde");
        ptItemM2_1.setItemPersonalizacao(itemM2_1);
        ItemPersonalizacaoTranslation enItemM2_1 = new ItemPersonalizacaoTranslation();

        enItemM2_1.setLocale(
                "en");
        enItemM2_1.setTexto(
                "Doctors, nurses, and healthcare professionals");
        enItemM2_1.setItemPersonalizacao(itemM2_1);

        itemM2_1.getTranslations()
                .addAll(Arrays.asList(ptItemM2_1, enItemM2_1));
        tipoMochila2.getItens()
                .add(itemM2_1);

// Item 2
        ItemPersonalizacao itemM2_2 = new ItemPersonalizacao();

        itemM2_2.setTipoPersonalizacao(tipoMochila2);
        ItemPersonalizacaoTranslation ptItemM2_2 = new ItemPersonalizacaoTranslation();

        ptItemM2_2.setLocale(
                "pt-BR");
        ptItemM2_2.setTexto(
                "Professoras e educadoras");
        ptItemM2_2.setItemPersonalizacao(itemM2_2);
        ItemPersonalizacaoTranslation enItemM2_2 = new ItemPersonalizacaoTranslation();

        enItemM2_2.setLocale(
                "en");
        enItemM2_2.setTexto(
                "Teachers and educators");
        enItemM2_2.setItemPersonalizacao(itemM2_2);

        itemM2_2.getTranslations()
                .addAll(Arrays.asList(ptItemM2_2, enItemM2_2));
        tipoMochila2.getItens()
                .add(itemM2_2);

// Item 3
        ItemPersonalizacao itemM2_3 = new ItemPersonalizacao();

        itemM2_3.setTipoPersonalizacao(tipoMochila2);
        ItemPersonalizacaoTranslation ptItemM2_3 = new ItemPersonalizacaoTranslation();

        ptItemM2_3.setLocale(
                "pt-BR");
        ptItemM2_3.setTexto(
                "Advogadas e executivas");
        ptItemM2_3.setItemPersonalizacao(itemM2_3);
        ItemPersonalizacaoTranslation enItemM2_3 = new ItemPersonalizacaoTranslation();

        enItemM2_3.setLocale(
                "en");
        enItemM2_3.setTexto(
                "Lawyers and executives");
        enItemM2_3.setItemPersonalizacao(itemM2_3);

        itemM2_3.getTranslations()
                .addAll(Arrays.asList(ptItemM2_3, enItemM2_3));
        tipoMochila2.getItens()
                .add(itemM2_3);

// Item 4
        ItemPersonalizacao itemM2_4 = new ItemPersonalizacao();

        itemM2_4.setTipoPersonalizacao(tipoMochila2);
        ItemPersonalizacaoTranslation ptItemM2_4 = new ItemPersonalizacaoTranslation();

        ptItemM2_4.setLocale(
                "pt-BR");
        ptItemM2_4.setTexto(
                "Símbolos e ferramentas da profissão");
        ptItemM2_4.setItemPersonalizacao(itemM2_4);
        ItemPersonalizacaoTranslation enItemM2_4 = new ItemPersonalizacaoTranslation();

        enItemM2_4.setLocale(
                "en");
        enItemM2_4.setTexto(
                "Symbols and tools of the profession");
        enItemM2_4.setItemPersonalizacao(itemM2_4);

        itemM2_4.getTranslations()
                .addAll(Arrays.asList(ptItemM2_4, enItemM2_4));
        tipoMochila2.getItens()
                .add(itemM2_4);

// Item 5
        ItemPersonalizacao itemM2_5 = new ItemPersonalizacao();

        itemM2_5.setTipoPersonalizacao(tipoMochila2);
        ItemPersonalizacaoTranslation ptItemM2_5 = new ItemPersonalizacaoTranslation();

        ptItemM2_5.setLocale(
                "pt-BR");
        ptItemM2_5.setTexto(
                "Frases motivacionais da área");
        ptItemM2_5.setItemPersonalizacao(itemM2_5);
        ItemPersonalizacaoTranslation enItemM2_5 = new ItemPersonalizacaoTranslation();

        enItemM2_5.setLocale(
                "en");
        enItemM2_5.setTexto(
                "Motivational quotes from the field");
        enItemM2_5.setItemPersonalizacao(itemM2_5);

        itemM2_5.getTranslations()
                .addAll(Arrays.asList(ptItemM2_5, enItemM2_5));
        tipoMochila2.getItens()
                .add(itemM2_5);
        TipoPersonalizacao tipoMochila3 = new TipoPersonalizacao();

        tipoMochila3.setNomeIcone(
                "star");
        tipoMochila3.setCategoria(mochilas);
        TipoPersonalizacaoTranslation ptTransM3 = new TipoPersonalizacaoTranslation();

        ptTransM3.setLocale(
                "pt-BR");
        ptTransM3.setTitulo(
                "Fé e Espiritualidade");
        ptTransM3.setTipoPersonalizacao(tipoMochila3);
        TipoPersonalizacaoTranslation enTransM3 = new TipoPersonalizacaoTranslation();

        enTransM3.setLocale(
                "en");
        enTransM3.setTitulo(
                "Faith & Spirituality");
        enTransM3.setTipoPersonalizacao(tipoMochila3);

        tipoMochila3.getTranslations()
                .addAll(Arrays.asList(ptTransM3, enTransM3));
        // --- Itens para "Fé e Espiritualidade" com tradução ---

// Item 1
        ItemPersonalizacao itemM3_1 = new ItemPersonalizacao();

        itemM3_1.setTipoPersonalizacao(tipoMochila3);
        ItemPersonalizacaoTranslation ptItemM3_1 = new ItemPersonalizacaoTranslation();

        ptItemM3_1.setLocale(
                "pt-BR");
        ptItemM3_1.setTexto(
                "Nossa Senhora e santos de devoção");
        ptItemM3_1.setItemPersonalizacao(itemM3_1);
        ItemPersonalizacaoTranslation enItemM3_1 = new ItemPersonalizacaoTranslation();

        enItemM3_1.setLocale(
                "en");
        enItemM3_1.setTexto(
                "Our Lady and patron saints");
        enItemM3_1.setItemPersonalizacao(itemM3_1);

        itemM3_1.getTranslations()
                .addAll(Arrays.asList(ptItemM3_1, enItemM3_1));
        tipoMochila3.getItens()
                .add(itemM3_1);

// Item 2
        ItemPersonalizacao itemM3_2 = new ItemPersonalizacao();

        itemM3_2.setTipoPersonalizacao(tipoMochila3);
        ItemPersonalizacaoTranslation ptItemM3_2 = new ItemPersonalizacaoTranslation();

        ptItemM3_2.setLocale(
                "pt-BR");
        ptItemM3_2.setTexto(
                "Versículos bíblicos especiais");
        ptItemM3_2.setItemPersonalizacao(itemM3_2);
        ItemPersonalizacaoTranslation enItemM3_2 = new ItemPersonalizacaoTranslation();

        enItemM3_2.setLocale(
                "en");
        enItemM3_2.setTexto(
                "Special bible verses");
        enItemM3_2.setItemPersonalizacao(itemM3_2);

        itemM3_2.getTranslations()
                .addAll(Arrays.asList(ptItemM3_2, enItemM3_2));
        tipoMochila3.getItens()
                .add(itemM3_2);

// Item 3
        ItemPersonalizacao itemM3_3 = new ItemPersonalizacao();

        itemM3_3.setTipoPersonalizacao(tipoMochila3);
        ItemPersonalizacaoTranslation ptItemM3_3 = new ItemPersonalizacaoTranslation();

        ptItemM3_3.setLocale(
                "pt-BR");
        ptItemM3_3.setTexto(
                "Símbolos religiosos personalizados");
        ptItemM3_3.setItemPersonalizacao(itemM3_3);
        ItemPersonalizacaoTranslation enItemM3_3 = new ItemPersonalizacaoTranslation();

        enItemM3_3.setLocale(
                "en");
        enItemM3_3.setTexto(
                "Custom religious symbols");
        enItemM3_3.setItemPersonalizacao(itemM3_3);

        itemM3_3.getTranslations()
                .addAll(Arrays.asList(ptItemM3_3, enItemM3_3));
        tipoMochila3.getItens()
                .add(itemM3_3);

// Item 4
        ItemPersonalizacao itemM3_4 = new ItemPersonalizacao();

        itemM3_4.setTipoPersonalizacao(tipoMochila3);
        ItemPersonalizacaoTranslation ptItemM3_4 = new ItemPersonalizacaoTranslation();

        ptItemM3_4.setLocale(
                "pt-BR");
        ptItemM3_4.setTexto(
                "Orações e mensagens de fé");
        ptItemM3_4.setItemPersonalizacao(itemM3_4);
        ItemPersonalizacaoTranslation enItemM3_4 = new ItemPersonalizacaoTranslation();

        enItemM3_4.setLocale(
                "en");
        enItemM3_4.setTexto(
                "Prayers and messages of faith");
        enItemM3_4.setItemPersonalizacao(itemM3_4);

        itemM3_4.getTranslations()
                .addAll(Arrays.asList(ptItemM3_4, enItemM3_4));
        tipoMochila3.getItens()
                .add(itemM3_4);

// Item 5
        ItemPersonalizacao itemM3_5 = new ItemPersonalizacao();

        itemM3_5.setTipoPersonalizacao(tipoMochila3);
        ItemPersonalizacaoTranslation ptItemM3_5 = new ItemPersonalizacaoTranslation();

        ptItemM3_5.setLocale(
                "pt-BR");
        ptItemM3_5.setTexto(
                "Anjos e elementos celestiais");
        ptItemM3_5.setItemPersonalizacao(itemM3_5);
        ItemPersonalizacaoTranslation enItemM3_5 = new ItemPersonalizacaoTranslation();

        enItemM3_5.setLocale(
                "en");
        enItemM3_5.setTexto(
                "Angels and celestial elements");
        enItemM3_5.setItemPersonalizacao(itemM3_5);

        itemM3_5.getTranslations()
                .addAll(Arrays.asList(ptItemM3_5, enItemM3_5));
        tipoMochila3.getItens()
                .add(itemM3_5);

        TipoPersonalizacao tipoMochila4 = new TipoPersonalizacao();

        tipoMochila4.setNomeIcone(
                "gamepad-2");
        tipoMochila4.setCategoria(mochilas);
        TipoPersonalizacaoTranslation ptTransM4 = new TipoPersonalizacaoTranslation();

        ptTransM4.setLocale(
                "pt-BR");
        ptTransM4.setTitulo(
                "Anime e Personagens");
        ptTransM4.setTipoPersonalizacao(tipoMochila4);
        TipoPersonalizacaoTranslation enTransM4 = new TipoPersonalizacaoTranslation();

        enTransM4.setLocale(
                "en");
        enTransM4.setTitulo(
                "Anime & Characters");
        enTransM4.setTipoPersonalizacao(tipoMochila4);

        tipoMochila4.getTranslations()
                .addAll(Arrays.asList(ptTransM4, enTransM4));
// --- Itens para "Anime e Personagens" com tradução ---

// Item 1
        ItemPersonalizacao itemM4_1 = new ItemPersonalizacao();

        itemM4_1.setTipoPersonalizacao(tipoMochila4);
        ItemPersonalizacaoTranslation ptItemM4_1 = new ItemPersonalizacaoTranslation();

        ptItemM4_1.setLocale(
                "pt-BR");
        ptItemM4_1.setTexto(
                "Personagens de anime favoritos");
        ptItemM4_1.setItemPersonalizacao(itemM4_1);
        ItemPersonalizacaoTranslation enItemM4_1 = new ItemPersonalizacaoTranslation();

        enItemM4_1.setLocale(
                "en");
        enItemM4_1.setTexto(
                "Favorite anime characters");
        enItemM4_1.setItemPersonalizacao(itemM4_1);

        itemM4_1.getTranslations()
                .addAll(Arrays.asList(ptItemM4_1, enItemM4_1));
        tipoMochila4.getItens()
                .add(itemM4_1);

// Item 2
        ItemPersonalizacao itemM4_2 = new ItemPersonalizacao();

        itemM4_2.setTipoPersonalizacao(tipoMochila4);
        ItemPersonalizacaoTranslation ptItemM4_2 = new ItemPersonalizacaoTranslation();

        ptItemM4_2.setLocale(
                "pt-BR");
        ptItemM4_2.setTexto(
                "Desenhos animados clássicos");
        ptItemM4_2.setItemPersonalizacao(itemM4_2);
        ItemPersonalizacaoTranslation enItemM4_2 = new ItemPersonalizacaoTranslation();

        enItemM4_2.setLocale(
                "en");
        enItemM4_2.setTexto(
                "Classic cartoon characters");
        enItemM4_2.setItemPersonalizacao(itemM4_2);

        itemM4_2.getTranslations()
                .addAll(Arrays.asList(ptItemM4_2, enItemM4_2));
        tipoMochila4.getItens()
                .add(itemM4_2);

// Item 3
        ItemPersonalizacao itemM4_3 = new ItemPersonalizacao();

        itemM4_3.setTipoPersonalizacao(tipoMochila4);
        ItemPersonalizacaoTranslation ptItemM4_3 = new ItemPersonalizacaoTranslation();

        ptItemM4_3.setLocale(
                "pt-BR");
        ptItemM4_3.setTexto(
                "Filmes e séries que você ama");
        ptItemM4_3.setItemPersonalizacao(itemM4_3);
        ItemPersonalizacaoTranslation enItemM4_3 = new ItemPersonalizacaoTranslation();

        enItemM4_3.setLocale(
                "en");
        enItemM4_3.setTexto(
                "Movies and series you love");
        enItemM4_3.setItemPersonalizacao(itemM4_3);

        itemM4_3.getTranslations()
                .addAll(Arrays.asList(ptItemM4_3, enItemM4_3));
        tipoMochila4.getItens()
                .add(itemM4_3);

// Item 4
        ItemPersonalizacao itemM4_4 = new ItemPersonalizacao();

        itemM4_4.setTipoPersonalizacao(tipoMochila4);
        ItemPersonalizacaoTranslation ptItemM4_4 = new ItemPersonalizacaoTranslation();

        ptItemM4_4.setLocale(
                "pt-BR");
        ptItemM4_4.setTexto(
                "Logos e símbolos icônicos");
        ptItemM4_4.setItemPersonalizacao(itemM4_4);
        ItemPersonalizacaoTranslation enItemM4_4 = new ItemPersonalizacaoTranslation();

        enItemM4_4.setLocale(
                "en");
        enItemM4_4.setTexto(
                "Iconic logos and symbols");
        enItemM4_4.setItemPersonalizacao(itemM4_4);

        itemM4_4.getTranslations()
                .addAll(Arrays.asList(ptItemM4_4, enItemM4_4));
        tipoMochila4.getItens()
                .add(itemM4_4);

// Item 5
        ItemPersonalizacao itemM4_5 = new ItemPersonalizacao();

        itemM4_5.setTipoPersonalizacao(tipoMochila4);
        ItemPersonalizacaoTranslation ptItemM4_5 = new ItemPersonalizacaoTranslation();

        ptItemM4_5.setLocale(
                "pt-BR");
        ptItemM4_5.setTexto(
                "Frases marcantes dos personagens");
        ptItemM4_5.setItemPersonalizacao(itemM4_5);
        ItemPersonalizacaoTranslation enItemM4_5 = new ItemPersonalizacaoTranslation();

        enItemM4_5.setLocale(
                "en");
        enItemM4_5.setTexto(
                "Memorable character quotes");
        enItemM4_5.setItemPersonalizacao(itemM4_5);

        itemM4_5.getTranslations()
                .addAll(Arrays.asList(ptItemM4_5, enItemM4_5));
        tipoMochila4.getItens()
                .add(itemM4_5);

        TipoPersonalizacao tipoMochila5 = new TipoPersonalizacao();

        tipoMochila5.setNomeIcone(
                "palette");
        tipoMochila5.setCategoria(mochilas);
        TipoPersonalizacaoTranslation ptTransM5 = new TipoPersonalizacaoTranslation();

        ptTransM5.setLocale(
                "pt-BR");
        ptTransM5.setTitulo(
                "Nomes e Monogramas");
        ptTransM5.setTipoPersonalizacao(tipoMochila5);
        TipoPersonalizacaoTranslation enTransM5 = new TipoPersonalizacaoTranslation();

        enTransM5.setLocale(
                "en");
        enTransM5.setTitulo(
                "Names & Monograms");
        enTransM5.setTipoPersonalizacao(tipoMochila5);

        tipoMochila5.getTranslations()
                .addAll(Arrays.asList(ptTransM5, enTransM5));
        // --- Itens para "Nomes e Monogramas" com tradução ---

// Item 1
        ItemPersonalizacao itemM5_1 = new ItemPersonalizacao();

        itemM5_1.setTipoPersonalizacao(tipoMochila5);
        ItemPersonalizacaoTranslation ptItemM5_1 = new ItemPersonalizacaoTranslation();

        ptItemM5_1.setLocale(
                "pt-BR");
        ptItemM5_1.setTexto(
                "Seu nome em tipografias exclusivas");
        ptItemM5_1.setItemPersonalizacao(itemM5_1);
        ItemPersonalizacaoTranslation enItemM5_1 = new ItemPersonalizacaoTranslation();

        enItemM5_1.setLocale(
                "en");
        enItemM5_1.setTexto(
                "Your name in exclusive fonts");
        enItemM5_1.setItemPersonalizacao(itemM5_1);

        itemM5_1.getTranslations()
                .addAll(Arrays.asList(ptItemM5_1, enItemM5_1));
        tipoMochila5.getItens()
                .add(itemM5_1);

// Item 2
        ItemPersonalizacao itemM5_2 = new ItemPersonalizacao();

        itemM5_2.setTipoPersonalizacao(tipoMochila5);
        ItemPersonalizacaoTranslation ptItemM5_2 = new ItemPersonalizacaoTranslation();

        ptItemM5_2.setLocale(
                "pt-BR");
        ptItemM5_2.setTexto(
                "Monogramas elegantes e sofisticados");
        ptItemM5_2.setItemPersonalizacao(itemM5_2);
        ItemPersonalizacaoTranslation enItemM5_2 = new ItemPersonalizacaoTranslation();

        enItemM5_2.setLocale(
                "en");
        enItemM5_2.setTexto(
                "Elegant and sophisticated monograms");
        enItemM5_2.setItemPersonalizacao(itemM5_2);

        itemM5_2.getTranslations()
                .addAll(Arrays.asList(ptItemM5_2, enItemM5_2));
        tipoMochila5.getItens()
                .add(itemM5_2);

// Item 3
        ItemPersonalizacao itemM5_3 = new ItemPersonalizacao();

        itemM5_3.setTipoPersonalizacao(tipoMochila5);
        ItemPersonalizacaoTranslation ptItemM5_3 = new ItemPersonalizacaoTranslation();

        ptItemM5_3.setLocale(
                "pt-BR");
        ptItemM5_3.setTexto(
                "Iniciais decorativas");
        ptItemM5_3.setItemPersonalizacao(itemM5_3);
        ItemPersonalizacaoTranslation enItemM5_3 = new ItemPersonalizacaoTranslation();

        enItemM5_3.setLocale(
                "en");
        enItemM5_3.setTexto(
                "Decorative initials");
        enItemM5_3.setItemPersonalizacao(itemM5_3);

        itemM5_3.getTranslations()
                .addAll(Arrays.asList(ptItemM5_3, enItemM5_3));
        tipoMochila5.getItens()
                .add(itemM5_3);

// Item 4
        ItemPersonalizacao itemM5_4 = new ItemPersonalizacao();

        itemM5_4.setTipoPersonalizacao(tipoMochila5);
        ItemPersonalizacaoTranslation ptItemM5_4 = new ItemPersonalizacaoTranslation();

        ptItemM5_4.setLocale(
                "pt-BR");
        ptItemM5_4.setTexto(
                "Combinações de nomes especiais");
        ptItemM5_4.setItemPersonalizacao(itemM5_4);
        ItemPersonalizacaoTranslation enItemM5_4 = new ItemPersonalizacaoTranslation();

        enItemM5_4.setLocale(
                "en");
        enItemM5_4.setTexto(
                "Special name combinations");
        enItemM5_4.setItemPersonalizacao(itemM5_4);

        itemM5_4.getTranslations()
                .addAll(Arrays.asList(ptItemM5_4, enItemM5_4));
        tipoMochila5.getItens()
                .add(itemM5_4);

// Item 5
        ItemPersonalizacao itemM5_5 = new ItemPersonalizacao();

        itemM5_5.setTipoPersonalizacao(tipoMochila5);
        ItemPersonalizacaoTranslation ptItemM5_5 = new ItemPersonalizacaoTranslation();

        ptItemM5_5.setLocale(
                "pt-BR");
        ptItemM5_5.setTexto(
                "Assinaturas personalizadas");
        ptItemM5_5.setItemPersonalizacao(itemM5_5);
        ItemPersonalizacaoTranslation enItemM5_5 = new ItemPersonalizacaoTranslation();

        enItemM5_5.setLocale(
                "en");
        enItemM5_5.setTexto(
                "Custom signatures");
        enItemM5_5.setItemPersonalizacao(itemM5_5);

        itemM5_5.getTranslations()
                .addAll(Arrays.asList(ptItemM5_5, enItemM5_5));
        tipoMochila5.getItens()
                .add(itemM5_5);

        TipoPersonalizacao tipoMochila6 = new TipoPersonalizacao();

        tipoMochila6.setNomeIcone(
                "sparkles");
        tipoMochila6.setCategoria(mochilas);
        TipoPersonalizacaoTranslation ptTransM6 = new TipoPersonalizacaoTranslation();

        ptTransM6.setLocale(
                "pt-BR");
        ptTransM6.setTitulo(
                "Estampas Exclusivas");
        ptTransM6.setTipoPersonalizacao(tipoMochila6);
        TipoPersonalizacaoTranslation enTransM6 = new TipoPersonalizacaoTranslation();

        enTransM6.setLocale(
                "en");
        enTransM6.setTitulo(
                "Exclusive Prints");
        enTransM6.setTipoPersonalizacao(tipoMochila6);

        tipoMochila6.getTranslations()
                .addAll(Arrays.asList(ptTransM6, enTransM6));
        // --- Itens para "Estampas Exclusivas" com tradução ---

// Item 1
        ItemPersonalizacao itemM6_1 = new ItemPersonalizacao();

        itemM6_1.setTipoPersonalizacao(tipoMochila6);
        ItemPersonalizacaoTranslation ptItemM6_1 = new ItemPersonalizacaoTranslation();

        ptItemM6_1.setLocale(
                "pt-BR");
        ptItemM6_1.setTexto(
                "Florais delicados e modernos");
        ptItemM6_1.setItemPersonalizacao(itemM6_1);
        ItemPersonalizacaoTranslation enItemM6_1 = new ItemPersonalizacaoTranslation();

        enItemM6_1.setLocale(
                "en");
        enItemM6_1.setTexto(
                "Delicate and modern florals");
        enItemM6_1.setItemPersonalizacao(itemM6_1);

        itemM6_1.getTranslations()
                .addAll(Arrays.asList(ptItemM6_1, enItemM6_1));
        tipoMochila6.getItens()
                .add(itemM6_1);

// Item 2
        ItemPersonalizacao itemM6_2 = new ItemPersonalizacao();

        itemM6_2.setTipoPersonalizacao(tipoMochila6);
        ItemPersonalizacaoTranslation ptItemM6_2 = new ItemPersonalizacaoTranslation();

        ptItemM6_2.setLocale(
                "pt-BR");
        ptItemM6_2.setTexto(
                "Padrões geométricos únicos");
        ptItemM6_2.setItemPersonalizacao(itemM6_2);
        ItemPersonalizacaoTranslation enItemM6_2 = new ItemPersonalizacaoTranslation();

        enItemM6_2.setLocale(
                "en");
        enItemM6_2.setTexto(
                "Unique geometric patterns");
        enItemM6_2.setItemPersonalizacao(itemM6_2);

        itemM6_2.getTranslations()
                .addAll(Arrays.asList(ptItemM6_2, enItemM6_2));
        tipoMochila6.getItens()
                .add(itemM6_2);

// Item 3
        ItemPersonalizacao itemM6_3 = new ItemPersonalizacao();

        itemM6_3.setTipoPersonalizacao(tipoMochila6);
        ItemPersonalizacaoTranslation ptItemM6_3 = new ItemPersonalizacaoTranslation();

        ptItemM6_3.setLocale(
                "pt-BR");
        ptItemM6_3.setTexto(
                "Aquarelas e arte abstrata");
        ptItemM6_3.setItemPersonalizacao(itemM6_3);
        ItemPersonalizacaoTranslation enItemM6_3 = new ItemPersonalizacaoTranslation();

        enItemM6_3.setLocale(
                "en");
        enItemM6_3.setTexto(
                "Watercolors and abstract art");
        enItemM6_3.setItemPersonalizacao(itemM6_3);

        itemM6_3.getTranslations()
                .addAll(Arrays.asList(ptItemM6_3, enItemM6_3));
        tipoMochila6.getItens()
                .add(itemM6_3);

// Item 4
        ItemPersonalizacao itemM6_4 = new ItemPersonalizacao();

        itemM6_4.setTipoPersonalizacao(tipoMochila6);
        ItemPersonalizacaoTranslation ptItemM6_4 = new ItemPersonalizacaoTranslation();

        ptItemM6_4.setLocale(
                "pt-BR");
        ptItemM6_4.setTexto(
                "Combinações de cores favoritas");
        ptItemM6_4.setItemPersonalizacao(itemM6_4);
        ItemPersonalizacaoTranslation enItemM6_4 = new ItemPersonalizacaoTranslation();

        enItemM6_4.setLocale(
                "en");
        enItemM6_4.setTexto(
                "Favorite color combinations");
        enItemM6_4.setItemPersonalizacao(itemM6_4);

        itemM6_4.getTranslations()
                .addAll(Arrays.asList(ptItemM6_4, enItemM6_4));
        tipoMochila6.getItens()
                .add(itemM6_4);

// Item 5
        ItemPersonalizacao itemM6_5 = new ItemPersonalizacao();

        itemM6_5.setTipoPersonalizacao(tipoMochila6);
        ItemPersonalizacaoTranslation ptItemM6_5 = new ItemPersonalizacaoTranslation();

        ptItemM6_5.setLocale(
                "pt-BR");
        ptItemM6_5.setTexto(
                "Texturas e efeitos especiais");
        ptItemM6_5.setItemPersonalizacao(itemM6_5);
        ItemPersonalizacaoTranslation enItemM6_5 = new ItemPersonalizacaoTranslation();

        enItemM6_5.setLocale(
                "en");
        enItemM6_5.setTexto(
                "Special textures and effects");
        enItemM6_5.setItemPersonalizacao(itemM6_5);

        itemM6_5.getTranslations()
                .addAll(Arrays.asList(ptItemM6_5, enItemM6_5));
        tipoMochila6.getItens()
                .add(itemM6_5);

// Salva todos os tipos de personalização para 'Mochilas' de uma vez
        tipoPersonalizacaoRepository.saveAll(Arrays.asList(tipoMochila1, tipoMochila2, tipoMochila3, tipoMochila4, tipoMochila5, tipoMochila6));
    }

    private void criarCategoriaLinhaBaby() {
// --- CATEGORIA LINHA BABY (COM VARIÁVEIS CORRIGIDAS) ---
// --- CATEGORIA LINHA BABY (VERSÃO COMPLETA E FINAL) ---
        Categoria linhaBaby = new Categoria();

        linhaBaby.setSlug(
                "linha-baby");
        linhaBaby.setImagemDestaqueUrl(
                "/images/Produtos/Linha Baby/960x640 Linha Baby Kit Aurora Inteiro.png");
        linhaBaby.setUrlImagemPersonalizacao(
                "/images/Produtos/Linha Baby/Linha BabyKit Higiene Bucal.jpg");
        linhaBaby.setImagemUrlHome(
                "/images/Home/LinhaBaby - Categoria.png");

        CategoriaTranslation ptLinhaBaby = new CategoriaTranslation();

        ptLinhaBaby.setLocale(
                "pt-BR");
        ptLinhaBaby.setCategoria(linhaBaby);

        ptLinhaBaby.setNomeSingular(
                "Item da Linha Baby");
        ptLinhaBaby.setNomePlural(
                "Linha Baby");
        ptLinhaBaby.setDescricao(
                "A chegada de um bebê transforma tudo. Nossa Linha Baby foi criada para tornar esse momento único ainda mais especial, trazendo praticidade, organização e muito amor para o dia a dia das mamães e dos papais.");
        ptLinhaBaby.setCtaTitle(
                "Organização e Carinho em Cada Detalhe");
        ptLinhaBaby.setCtaDescription(
                "Personalize cada item com nome, cor e estampa – do jeitinho que você sonhou!");
        ptLinhaBaby.setCtaAttention(
                "✨ Produtos 100% personalizáveis • Organização e praticidade para a rotina da mamãe • Feito com carinho");
        ptLinhaBaby.setCtaButtonText(
                "💝 Criar Meu Kit Baby");
        ptLinhaBaby.setHeroTitle(
                "Organização e Carinho em Cada Detalhe Para o Seu Bebê");
        ptLinhaBaby.setHeroButtonText(
                "💝 Criar Meu Kit Baby");
        ptLinhaBaby.setGaleriaTitle(
                "Feito para Facilitar a Vida das Mamães");
        ptLinhaBaby.setGaleriaDescricao(
                "Sabemos que a rotina de uma mãe de recém-nascido é cheia de desafios. Por isso, cada item da Linha Baby é pensado para trazer mais praticidade, organização e tranquilidade para o seu dia a dia. E o melhor: tudo 100% personalizável, para deixar esse momento ainda mais especial e único.");

        CategoriaTranslation enLinhaBaby = new CategoriaTranslation();

        enLinhaBaby.setLocale(
                "en");
        enLinhaBaby.setCategoria(linhaBaby);

        enLinhaBaby.setNomeSingular(
                "Baby Line Item");
        enLinhaBaby.setNomePlural(
                "Baby Line");
        enLinhaBaby.setDescricao(
                "A baby's arrival changes everything. Our Baby Line was created to make this unique moment even more special, bringing practicality, organization, and lots of love to the daily lives of moms and dads.");
        enLinhaBaby.setCtaTitle(
                "Organization and Care in Every Detail");
        enLinhaBaby.setCtaDescription(
                "Customize each item with a name, color, and print – just the way you dreamed!");
        enLinhaBaby.setCtaAttention(
                "✨ 100% customizable products • Organization and convenience for mom's routine • Made with love");
        enLinhaBaby.setCtaButtonText(
                "💝 Create My Baby Kit");
        enLinhaBaby.setHeroTitle(
                "Organization and Care in Every Detail For Your Baby");
        enLinhaBaby.setHeroButtonText(
                "💝 Create My Baby Kit");
        enLinhaBaby.setGaleriaTitle(
                "Made to Make Moms' Lives Easier");
        enLinhaBaby.setGaleriaDescricao(
                "We know that a mom's routine with a newborn is full of challenges. That's why each item in the Baby Line is designed to bring more practicality, organization, and tranquility to your daily life. And the best part: everything is 100% customizable, to make this moment even more special and unique.");

        linhaBaby.getTranslations()
                .addAll(Arrays.asList(ptLinhaBaby, enLinhaBaby));
        categoriaRepository.save(linhaBaby);

// --- Produtos para a categoria Linha Baby ---
        Produto pBB1 = new Produto("/images/Produtos/Linha Baby/960x640 Linha Baby Farmacinha Aurora.png", linhaBaby);
        ProdutoTranslation ptPBB1 = new ProdutoTranslation();

        ptPBB1.setLocale(
                "pt-BR");
        ptPBB1.setNome(
                "Farmacinha Personalizada");
        ptPBB1.setDescricao(
                "Ideal para armazenar os medicamentos do bebe separado dos demais medicamentos da casa, garantindo que nada ficou pra trás! Personalize com nome, tema e cores!");
        ptPBB1.setProduto(pBB1);
        ProdutoTranslation enPBB1 = new ProdutoTranslation();

        enPBB1.setLocale(
                "en");
        enPBB1.setNome(
                "Custom First Aid Box");
        enPBB1.setDescricao(
                "Ideal for storing the baby's medicines separately from the rest of the household's, ensuring nothing is left behind! Customize with name, theme, and colors!");
        enPBB1.setProduto(pBB1);

        pBB1.getTranslations()
                .addAll(Arrays.asList(ptPBB1, enPBB1));

        Produto pBB2 = new Produto("/images/Produtos/Linha Baby/960x640 Linha Baby Aurora Necessaire.png", linhaBaby);
        ProdutoTranslation ptPBB2 = new ProdutoTranslation();

        ptPBB2.setLocale(
                "pt-BR");
        ptPBB2.setNome(
                "Necessaire Baby");
        ptPBB2.setDescricao(
                "Sim, essa peça versátil também é queridinha das mamães! Ideal para fraldas, pomadas e itens de higiene. Praticidade para a mamãe, conforto para o bebê.");
        ptPBB2.setProduto(pBB2);
        ProdutoTranslation enPBB2 = new ProdutoTranslation();

        enPBB2.setLocale(
                "en");
        enPBB2.setNome(
                "Baby Pouch");
        enPBB2.setDescricao(
                "Yes, this versatile piece is also a favorite among moms! Ideal for diapers, ointments, and hygiene items. Practicality for mom, comfort for the baby.");
        enPBB2.setProduto(pBB2);

        pBB2.getTranslations()
                .addAll(Arrays.asList(ptPBB2, enPBB2));

        Produto pBB3 = new Produto("/images/Produtos/Linha Baby/960x640 Linha Baby Aurora Porta Lencinho.png", linhaBaby);
        ProdutoTranslation ptPBB3 = new ProdutoTranslation();

        ptPBB3.setLocale(
                "pt-BR");
        ptPBB3.setNome(
                "Porta Lencinho e Fralda");
        ptPBB3.setDescricao(
                "Tenha sempre os lencinhos e fraldas à mão, com praticidade e estilo. Seja em casa ou no passeio. Um item indispensável para facilitar a higiene do bebê em qualquer momento.");
        ptPBB3.setProduto(pBB3);
        ProdutoTranslation enPBB3 = new ProdutoTranslation();

        enPBB3.setLocale(
                "en");
        enPBB3.setNome(
                "Wipes and Diaper Holder");
        enPBB3.setDescricao(
                "Always have wipes and diapers on hand, with practicality and style. Whether at home or on the go. An essential item to facilitate the baby's hygiene at any time.");
        enPBB3.setProduto(pBB3);

        pBB3.getTranslations()
                .addAll(Arrays.asList(ptPBB3, enPBB3));

        Produto pBB4 = new Produto("/images/Produtos/Linha Baby/960x640 Linha Baby Aurora Carteira Pediatrica.png", linhaBaby);
        ProdutoTranslation ptPBB4 = new ProdutoTranslation();

        ptPBB4.setLocale(
                "pt-BR");
        ptPBB4.setNome(
                "Carteira Pediátrica");
        ptPBB4.setDescricao(
                "Guarde a carteirinha de vacinação, documentos e receitas do bebê de forma segura e organizada. Tudo pronto para as consultas e emergências.");
        ptPBB4.setProduto(pBB4);
        ProdutoTranslation enPBB4 = new ProdutoTranslation();

        enPBB4.setLocale(
                "en");
        enPBB4.setNome(
                "Pediatric Wallet");
        enPBB4.setDescricao(
                "Keep the vaccination card, documents, and baby's prescriptions safe and organized. Everything ready for appointments and emergencies.");
        enPBB4.setProduto(pBB4);

        pBB4.getTranslations()
                .addAll(Arrays.asList(ptPBB4, enPBB4));

        Produto pBB5 = new Produto("/images/Produtos/Linha Baby/960x640 Linha Baby Aurora Saquinho de Roupas.png", linhaBaby);
        ProdutoTranslation ptPBB5 = new ProdutoTranslation();

        ptPBB5.setLocale(
                "pt-BR");
        ptPBB5.setNome(
                "Saquinho de Roupas");
        ptPBB5.setDescricao(
                "Separe as roupinhas sujas ou limpas na bolsa do bebê. Perfeito para creche, passeios ou viagens, facilitando o dia a dia da mamãe!");
        ptPBB5.setProduto(pBB5);
        ProdutoTranslation enPBB5 = new ProdutoTranslation();

        enPBB5.setLocale(
                "en");
        enPBB5.setNome(
                "Clothing Bag");
        enPBB5.setDescricao(
                "Separate dirty or clean clothes in the baby's bag. Perfect for daycare, outings, or trips, making mom's daily life easier!");
        enPBB5.setProduto(pBB5);

        pBB5.getTranslations()
                .addAll(Arrays.asList(ptPBB5, enPBB5));

        Produto pBB6 = new Produto("/images/Produtos/Linha Baby/960x640 Linha Baby Aurora Trocador.png", linhaBaby);
        ProdutoTranslation ptPBB6 = new ProdutoTranslation();

        ptPBB6.setLocale(
                "pt-BR");
        ptPBB6.setNome(
                "Trocador Portátil");
        ptPBB6.setDescricao(
                "Praticidade para trocar o bebê em qualquer lugar, com conforto e higiene. Um verdadeiro aliado para as situações de emergência!");
        ptPBB6.setProduto(pBB6);
        ProdutoTranslation enPBB6 = new ProdutoTranslation();

        enPBB6.setLocale(
                "en");
        enPBB6.setNome(
                "Portable Changing Pad");
        enPBB6.setDescricao(
                "Practicality to change the baby anywhere, with comfort and hygiene. A true ally for emergency situations!");
        enPBB6.setProduto(pBB6);

        pBB6.getTranslations()
                .addAll(Arrays.asList(ptPBB6, enPBB6));
        produtoRepository.saveAll(Arrays.asList(pBB1, pBB2, pBB3, pBB4, pBB5, pBB6));

// --- Depoimentos para a categoria Linha Baby ---
        Depoimento depBB1 = new Depoimento("Mariana, mãe do Guilherme", "\"O saquinho de roupas sujas do Guilherme virou meu aliado! Agora consigo separar tudo direitinho na bolsa e ainda ficou lindo com o tema de astronauta. Praticidade e fofura juntos!💞\"", "/images/Produtos/Linha Baby/790x770 Linha Baby Guilherme.png", linhaBaby);
        Depoimento depBB2 = new Depoimento("Camila, mãe da Helena", "\"Meu marido comprou o kit para nossa filha Helena e foi o melhor presente! A bolsa, o porta-documentos e a necessaire facilitam muito na hora de sair de casa.🥰 Não saio sem eles!\"", "/images/Produtos/Linha Baby/790x770 Linha Baby Kit Helena.png", linhaBaby);
        Depoimento depBB3 = new Depoimento("Juliana, mãe da Violeta", "\"Amei poder escolher cada detalhe do kit da minha filha Violeta. O porta-vacinas é super prático e a necessaire cabe tudo o que preciso. Quando chegou ficamos emociados! É uma fase única nas nossas vidas!🩷💞\"", "/images/Produtos/Linha Baby/790x770 Linha Baby Violeta.png", linhaBaby);

        depoimentoRepository.saveAll(Arrays.asList(depBB1, depBB2, depBB3));

// --- Tipos de Personalização para a categoria Linha Baby ---
// TIPO 1
        TipoPersonalizacao tipoBB1 = new TipoPersonalizacao();

        tipoBB1.setNomeIcone(
                "palette");
        tipoBB1.setCategoria(linhaBaby);
        TipoPersonalizacaoTranslation ptTransBB1 = new TipoPersonalizacaoTranslation();

        ptTransBB1.setLocale(
                "pt-BR");
        ptTransBB1.setTitulo(
                "Cores e Estampas");
        ptTransBB1.setTipoPersonalizacao(tipoBB1);
        TipoPersonalizacaoTranslation enTransBB1 = new TipoPersonalizacaoTranslation();

        enTransBB1.setLocale(
                "en");
        enTransBB1.setTitulo(
                "Colors and Prints");
        enTransBB1.setTipoPersonalizacao(tipoBB1);

        tipoBB1.getTranslations()
                .addAll(Arrays.asList(ptTransBB1, enTransBB1));

        ItemPersonalizacao itemBB1_1 = new ItemPersonalizacao();

        itemBB1_1.setTipoPersonalizacao(tipoBB1);
        ItemPersonalizacaoTranslation ptItemBB1_1 = new ItemPersonalizacaoTranslation();

        ptItemBB1_1.setLocale(
                "pt-BR");
        ptItemBB1_1.setTexto(
                "Combinações de cores exclusivas");
        ptItemBB1_1.setItemPersonalizacao(itemBB1_1);
        ItemPersonalizacaoTranslation enItemBB1_1 = new ItemPersonalizacaoTranslation();

        enItemBB1_1.setLocale(
                "en");
        enItemBB1_1.setTexto(
                "Exclusive color combinations");
        enItemBB1_1.setItemPersonalizacao(itemBB1_1);

        itemBB1_1.getTranslations()
                .addAll(Arrays.asList(ptItemBB1_1, enItemBB1_1));
        tipoBB1.getItens()
                .add(itemBB1_1);

        ItemPersonalizacao itemBB1_2 = new ItemPersonalizacao();

        itemBB1_2.setTipoPersonalizacao(tipoBB1);
        ItemPersonalizacaoTranslation ptItemBB1_2 = new ItemPersonalizacaoTranslation();

        ptItemBB1_2.setLocale(
                "pt-BR");
        ptItemBB1_2.setTexto(
                "Estampas florais, poá, listras e mais");
        ptItemBB1_2.setItemPersonalizacao(itemBB1_2);
        ItemPersonalizacaoTranslation enItemBB1_2 = new ItemPersonalizacaoTranslation();

        enItemBB1_2.setLocale(
                "en");
        enItemBB1_2.setTexto(
                "Floral, polka dot, stripes and more prints");
        enItemBB1_2.setItemPersonalizacao(itemBB1_2);

        itemBB1_2.getTranslations()
                .addAll(Arrays.asList(ptItemBB1_2, enItemBB1_2));
        tipoBB1.getItens()
                .add(itemBB1_2);

        ItemPersonalizacao itemBB1_3 = new ItemPersonalizacao();

        itemBB1_3.setTipoPersonalizacao(tipoBB1);
        ItemPersonalizacaoTranslation ptItemBB1_3 = new ItemPersonalizacaoTranslation();

        ptItemBB1_3.setLocale(
                "pt-BR");
        ptItemBB1_3.setTexto(
                "Mix de padrões para todos os estilos");
        ptItemBB1_3.setItemPersonalizacao(itemBB1_3);
        ItemPersonalizacaoTranslation enItemBB1_3 = new ItemPersonalizacaoTranslation();

        enItemBB1_3.setLocale(
                "en");
        enItemBB1_3.setTexto(
                "Mix of patterns for all styles");
        enItemBB1_3.setItemPersonalizacao(itemBB1_3);

        itemBB1_3.getTranslations()
                .addAll(Arrays.asList(ptItemBB1_3, enItemBB1_3));
        tipoBB1.getItens()
                .add(itemBB1_3);

// TIPO 2
        TipoPersonalizacao tipoBB2 = new TipoPersonalizacao();

        tipoBB2.setNomeIcone(
                "smile");
        tipoBB2.setCategoria(linhaBaby);
        TipoPersonalizacaoTranslation ptTransBB2 = new TipoPersonalizacaoTranslation();

        ptTransBB2.setLocale(
                "pt-BR");
        ptTransBB2.setTitulo(
                "Animais e Personagens");
        ptTransBB2.setTipoPersonalizacao(tipoBB2);
        TipoPersonalizacaoTranslation enTransBB2 = new TipoPersonalizacaoTranslation();

        enTransBB2.setLocale(
                "en");
        enTransBB2.setTitulo(
                "Animals and Characters");
        enTransBB2.setTipoPersonalizacao(tipoBB2);

        tipoBB2.getTranslations()
                .addAll(Arrays.asList(ptTransBB2, enTransBB2));

        ItemPersonalizacao itemBB2_1 = new ItemPersonalizacao();

        itemBB2_1.setTipoPersonalizacao(tipoBB2);
        ItemPersonalizacaoTranslation ptItemBB2_1 = new ItemPersonalizacaoTranslation();

        ptItemBB2_1.setLocale(
                "pt-BR");
        ptItemBB2_1.setTexto(
                "Bichinhos fofos e personagens infantis");
        ptItemBB2_1.setItemPersonalizacao(itemBB2_1);
        ItemPersonalizacaoTranslation enItemBB2_1 = new ItemPersonalizacaoTranslation();

        enItemBB2_1.setLocale(
                "en");
        enItemBB2_1.setTexto(
                "Cute animals and children's characters");
        enItemBB2_1.setItemPersonalizacao(itemBB2_1);

        itemBB2_1.getTranslations()
                .addAll(Arrays.asList(ptItemBB2_1, enItemBB2_1));
        tipoBB2.getItens()
                .add(itemBB2_1);

        ItemPersonalizacao itemBB2_2 = new ItemPersonalizacao();

        itemBB2_2.setTipoPersonalizacao(tipoBB2);
        ItemPersonalizacaoTranslation ptItemBB2_2 = new ItemPersonalizacaoTranslation();

        ptItemBB2_2.setLocale(
                "pt-BR");
        ptItemBB2_2.setTexto(
                "Temas lúdicos para encantar");
        ptItemBB2_2.setItemPersonalizacao(itemBB2_2);
        ItemPersonalizacaoTranslation enItemBB2_2 = new ItemPersonalizacaoTranslation();

        enItemBB2_2.setLocale(
                "en");
        enItemBB2_2.setTexto(
                "Playful themes to delight");
        enItemBB2_2.setItemPersonalizacao(itemBB2_2);

        itemBB2_2.getTranslations()
                .addAll(Arrays.asList(ptItemBB2_2, enItemBB2_2));
        tipoBB2.getItens()
                .add(itemBB2_2);

        ItemPersonalizacao itemBB2_3 = new ItemPersonalizacao();

        itemBB2_3.setTipoPersonalizacao(tipoBB2);
        ItemPersonalizacaoTranslation ptItemBB2_3 = new ItemPersonalizacaoTranslation();

        ptItemBB2_3.setLocale(
                "pt-BR");
        ptItemBB2_3.setTexto(
                "Personalize com o favorito do seu filho");
        ptItemBB2_3.setItemPersonalizacao(itemBB2_3);
        ItemPersonalizacaoTranslation enItemBB2_3 = new ItemPersonalizacaoTranslation();

        enItemBB2_3.setLocale(
                "en");
        enItemBB2_3.setTexto(
                "Customize with your child's favorite");
        enItemBB2_3.setItemPersonalizacao(itemBB2_3);

        itemBB2_3.getTranslations()
                .addAll(Arrays.asList(ptItemBB2_3, enItemBB2_3));
        tipoBB2.getItens()
                .add(itemBB2_3);

// TIPO 3
        TipoPersonalizacao tipoBB3 = new TipoPersonalizacao();

        tipoBB3.setNomeIcone(
                "calendar");
        tipoBB3.setCategoria(linhaBaby);
        TipoPersonalizacaoTranslation ptTransBB3 = new TipoPersonalizacaoTranslation();

        ptTransBB3.setLocale(
                "pt-BR");
        ptTransBB3.setTitulo(
                "Datas Especiais");
        ptTransBB3.setTipoPersonalizacao(tipoBB3);
        TipoPersonalizacaoTranslation enTransBB3 = new TipoPersonalizacaoTranslation();

        enTransBB3.setLocale(
                "en");
        enTransBB3.setTitulo(
                "Special Dates");
        enTransBB3.setTipoPersonalizacao(tipoBB3);

        tipoBB3.getTranslations()
                .addAll(Arrays.asList(ptTransBB3, enTransBB3));

        ItemPersonalizacao itemBB3_1 = new ItemPersonalizacao();

        itemBB3_1.setTipoPersonalizacao(tipoBB3);
        ItemPersonalizacaoTranslation ptItemBB3_1 = new ItemPersonalizacaoTranslation();

        ptItemBB3_1.setLocale(
                "pt-BR");
        ptItemBB3_1.setTexto(
                "Nome do bebê e data de nascimento");
        ptItemBB3_1.setItemPersonalizacao(itemBB3_1);
        ItemPersonalizacaoTranslation enItemBB3_1 = new ItemPersonalizacaoTranslation();

        enItemBB3_1.setLocale(
                "en");
        enItemBB3_1.setTexto(
                "Baby's name and date of birth");
        enItemBB3_1.setItemPersonalizacao(itemBB3_1);

        itemBB3_1.getTranslations()
                .addAll(Arrays.asList(ptItemBB3_1, enItemBB3_1));
        tipoBB3.getItens()
                .add(itemBB3_1);

        ItemPersonalizacao itemBB3_2 = new ItemPersonalizacao();

        itemBB3_2.setTipoPersonalizacao(tipoBB3);
        ItemPersonalizacaoTranslation ptItemBB3_2 = new ItemPersonalizacaoTranslation();

        ptItemBB3_2.setLocale(
                "pt-BR");
        ptItemBB3_2.setTexto(
                "Frases marcantes da família");
        ptItemBB3_2.setItemPersonalizacao(itemBB3_2);
        ItemPersonalizacaoTranslation enItemBB3_2 = new ItemPersonalizacaoTranslation();

        enItemBB3_2.setLocale(
                "en");
        enItemBB3_2.setTexto(
                "Meaningful family phrases");
        enItemBB3_2.setItemPersonalizacao(itemBB3_2);

        itemBB3_2.getTranslations()
                .addAll(Arrays.asList(ptItemBB3_2, enItemBB3_2));
        tipoBB3.getItens()
                .add(itemBB3_2);

        ItemPersonalizacao itemBB3_3 = new ItemPersonalizacao();

        itemBB3_3.setTipoPersonalizacao(tipoBB3);
        ItemPersonalizacaoTranslation ptItemBB3_3 = new ItemPersonalizacaoTranslation();

        ptItemBB3_3.setLocale(
                "pt-BR");
        ptItemBB3_3.setTexto(
                "Homenagens para pessoas queridas");
        ptItemBB3_3.setItemPersonalizacao(itemBB3_3);
        ItemPersonalizacaoTranslation enItemBB3_3 = new ItemPersonalizacaoTranslation();

        enItemBB3_3.setLocale(
                "en");
        enItemBB3_3.setTexto(
                "Tributes to loved ones");
        enItemBB3_3.setItemPersonalizacao(itemBB3_3);

        itemBB3_3.getTranslations()
                .addAll(Arrays.asList(ptItemBB3_3, enItemBB3_3));
        tipoBB3.getItens()
                .add(itemBB3_3);

// TIPO 4
        TipoPersonalizacao tipoBB4 = new TipoPersonalizacao();

        tipoBB4.setNomeIcone(
                "sparkles");
        tipoBB4.setCategoria(linhaBaby);
        TipoPersonalizacaoTranslation ptTransBB4 = new TipoPersonalizacaoTranslation();

        ptTransBB4.setLocale(
                "pt-BR");
        ptTransBB4.setTitulo(
                "Design Exclusivo");
        ptTransBB4.setTipoPersonalizacao(tipoBB4);
        TipoPersonalizacaoTranslation enTransBB4 = new TipoPersonalizacaoTranslation();

        enTransBB4.setLocale(
                "en");
        enTransBB4.setTitulo(
                "Exclusive Design");
        enTransBB4.setTipoPersonalizacao(tipoBB4);

        tipoBB4.getTranslations()
                .addAll(Arrays.asList(ptTransBB4, enTransBB4));

        ItemPersonalizacao itemBB4_1 = new ItemPersonalizacao();

        itemBB4_1.setTipoPersonalizacao(tipoBB4);
        ItemPersonalizacaoTranslation ptItemBB4_1 = new ItemPersonalizacaoTranslation();

        ptItemBB4_1.setLocale(
                "pt-BR");
        ptItemBB4_1.setTexto(
                "Você escolhe o tema, as cores e o nome.");
        ptItemBB4_1.setItemPersonalizacao(itemBB4_1);
        ItemPersonalizacaoTranslation enItemBB4_1 = new ItemPersonalizacaoTranslation();

        enItemBB4_1.setLocale(
                "en");
        enItemBB4_1.setTexto(
                "You choose the theme, colors, and name.");
        enItemBB4_1.setItemPersonalizacao(itemBB4_1);

        itemBB4_1.getTranslations()
                .addAll(Arrays.asList(ptItemBB4_1, enItemBB4_1));
        tipoBB4.getItens()
                .add(itemBB4_1);

        ItemPersonalizacao itemBB4_2 = new ItemPersonalizacao();

        itemBB4_2.setTipoPersonalizacao(tipoBB4);
        ItemPersonalizacaoTranslation ptItemBB4_2 = new ItemPersonalizacaoTranslation();

        ptItemBB4_2.setLocale(
                "pt-BR");
        ptItemBB4_2.setTexto(
                "Criamos tudo do zero para combinar com o enxoval.");
        ptItemBB4_2.setItemPersonalizacao(itemBB4_2);
        ItemPersonalizacaoTranslation enItemBB4_2 = new ItemPersonalizacaoTranslation();

        enItemBB4_2.setLocale(
                "en");
        enItemBB4_2.setTexto(
                "We create everything from scratch to match the layette.");
        enItemBB4_2.setItemPersonalizacao(itemBB4_2);

        itemBB4_2.getTranslations()
                .addAll(Arrays.asList(ptItemBB4_2, enItemBB4_2));
        tipoBB4.getItens()
                .add(itemBB4_2);

// TIPO 5
        TipoPersonalizacao tipoBB5 = new TipoPersonalizacao();

        tipoBB5.setNomeIcone(
                "heart");
        tipoBB5.setCategoria(linhaBaby);
        TipoPersonalizacaoTranslation ptTransBB5 = new TipoPersonalizacaoTranslation();

        ptTransBB5.setLocale(
                "pt-BR");
        ptTransBB5.setTitulo(
                "Funcionalidade com Carinho");
        ptTransBB5.setTipoPersonalizacao(tipoBB5);
        TipoPersonalizacaoTranslation enTransBB5 = new TipoPersonalizacaoTranslation();

        enTransBB5.setLocale(
                "en");
        enTransBB5.setTitulo(
                "Functionality with Care");
        enTransBB5.setTipoPersonalizacao(tipoBB5);

        tipoBB5.getTranslations()
                .addAll(Arrays.asList(ptTransBB5, enTransBB5));

        ItemPersonalizacao itemBB5_1 = new ItemPersonalizacao();

        itemBB5_1.setTipoPersonalizacao(tipoBB5);
        ItemPersonalizacaoTranslation ptItemBB5_1 = new ItemPersonalizacaoTranslation();

        ptItemBB5_1.setLocale(
                "pt-BR");
        ptItemBB5_1.setTexto(
                "Cada produto é pensado para facilitar a rotina da mamãe.");
        ptItemBB5_1.setItemPersonalizacao(itemBB5_1);
        ItemPersonalizacaoTranslation enItemBB5_1 = new ItemPersonalizacaoTranslation();

        enItemBB5_1.setLocale(
                "en");
        enItemBB5_1.setTexto(
                "Each product is designed to make mom's routine easier.");
        enItemBB5_1.setItemPersonalizacao(itemBB5_1);

        itemBB5_1.getTranslations()
                .addAll(Arrays.asList(ptItemBB5_1, enItemBB5_1));
        tipoBB5.getItens()
                .add(itemBB5_1);

        ItemPersonalizacao itemBB5_2 = new ItemPersonalizacao();

        itemBB5_2.setTipoPersonalizacao(tipoBB5);
        ItemPersonalizacaoTranslation ptItemBB5_2 = new ItemPersonalizacaoTranslation();

        ptItemBB5_2.setLocale(
                "pt-BR");
        ptItemBB5_2.setTexto(
                "Mais organização, praticidade e beleza para o dia a dia.");
        ptItemBB5_2.setItemPersonalizacao(itemBB5_2);
        ItemPersonalizacaoTranslation enItemBB5_2 = new ItemPersonalizacaoTranslation();

        enItemBB5_2.setLocale(
                "en");
        enItemBB5_2.setTexto(
                "More organization, practicality, and beauty for everyday life.");
        enItemBB5_2.setItemPersonalizacao(itemBB5_2);

        itemBB5_2.getTranslations()
                .addAll(Arrays.asList(ptItemBB5_2, enItemBB5_2));
        tipoBB5.getItens()
                .add(itemBB5_2);

// TIPO 6
        TipoPersonalizacao tipoBB6 = new TipoPersonalizacao();

        tipoBB6.setNomeIcone(
                "users");
        tipoBB6.setCategoria(linhaBaby);
        TipoPersonalizacaoTranslation ptTransBB6 = new TipoPersonalizacaoTranslation();

        ptTransBB6.setLocale(
                "pt-BR");
        ptTransBB6.setTitulo(
                "Você Participa de Tudo");
        ptTransBB6.setTipoPersonalizacao(tipoBB6);
        TipoPersonalizacaoTranslation enTransBB6 = new TipoPersonalizacaoTranslation();

        enTransBB6.setLocale(
                "en");
        enTransBB6.setTitulo(
                "You Participate in Everything");
        enTransBB6.setTipoPersonalizacao(tipoBB6);

        tipoBB6.getTranslations()
                .addAll(Arrays.asList(ptTransBB6, enTransBB6));

        ItemPersonalizacao itemBB6_1 = new ItemPersonalizacao();

        itemBB6_1.setTipoPersonalizacao(tipoBB6);
        ItemPersonalizacaoTranslation ptItemBB6_1 = new ItemPersonalizacaoTranslation();

        ptItemBB6_1.setLocale(
                "pt-BR");
        ptItemBB6_1.setTexto(
                "Acompanhamos cada etapa junto com você.");
        ptItemBB6_1.setItemPersonalizacao(itemBB6_1);
        ItemPersonalizacaoTranslation enItemBB6_1 = new ItemPersonalizacaoTranslation();

        enItemBB6_1.setLocale(
                "en");
        enItemBB6_1.setTexto(
                "We follow each step together with you.");
        enItemBB6_1.setItemPersonalizacao(itemBB6_1);

        itemBB6_1.getTranslations()
                .addAll(Arrays.asList(ptItemBB6_1, enItemBB6_1));
        tipoBB6.getItens()
                .add(itemBB6_1);

        ItemPersonalizacao itemBB6_2 = new ItemPersonalizacao();

        itemBB6_2.setTipoPersonalizacao(tipoBB6);
        ItemPersonalizacaoTranslation ptItemBB6_2 = new ItemPersonalizacaoTranslation();

        ptItemBB6_2.setLocale(
                "pt-BR");
        ptItemBB6_2.setTexto(
                "Garantimos que o resultado final seja como você sonhou.");
        ptItemBB6_2.setItemPersonalizacao(itemBB6_2);
        ItemPersonalizacaoTranslation enItemBB6_2 = new ItemPersonalizacaoTranslation();

        enItemBB6_2.setLocale(
                "en");
        enItemBB6_2.setTexto(
                "We ensure the final result is just as you dreamed.");
        enItemBB6_2.setItemPersonalizacao(itemBB6_2);

        itemBB6_2.getTranslations()
                .addAll(Arrays.asList(ptItemBB6_2, enItemBB6_2));
        tipoBB6.getItens()
                .add(itemBB6_2);

// --- AO FINAL, SALVE TODOS OS TIPOS DE PERSONALIZAÇÃO DE UMA VEZ ---
// O JPA/Hibernate se encarregará de salvar os itens e traduções em cascata.
        tipoPersonalizacaoRepository.saveAll(Arrays.asList(tipoBB1, tipoBB2, tipoBB3, tipoBB4, tipoBB5, tipoBB6));

    }
}
