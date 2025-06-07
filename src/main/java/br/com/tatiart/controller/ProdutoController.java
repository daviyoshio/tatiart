package br.com.tatiart.controller;

import br.com.tatiart.model.CtaFinal;
import br.com.tatiart.model.Etapa;
import br.com.tatiart.model.Feature;
import br.com.tatiart.model.Personalizacao;
import br.com.tatiart.model.ProdutoView;
import br.com.tatiart.model.Testimonial;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProdutoController {

    private List<Etapa> gerarEtapasPadrao() {
        return Arrays.asList(
                new Etapa(1, "heart", "Conte Sua História", "Compartilhe conosco sua ideia, fotos, frases ou qualquer inspiração."),
                new Etapa(2, "palette", "Criamos o Design", "Nossa equipe cria um projeto exclusivo com sua aprovação."),
                new Etapa(3, "coffee", "Produção Artesanal", "Produzimos com materiais premium e técnicas especiais."),
                new Etapa(4, "gift", "Entrega Especial", "Embalamos com carinho e enviamos para você.")
        );
    }

    @GetMapping("/produtos")
    public String listarProdutos(Model model) {
        List<ProdutoView> produtos = new ArrayList<>();

        produtos.add(new ProdutoView(
                "Canecas Personalizadas",
                "Canecas feitas sob medida com seu nome ou frase favorita.",
                new String[]{"Durável", "Criativa"},
                new String[]{"/images/canecas/caneca1.png"},
                new String[]{"Cerâmica de alta qualidade"},
                "/images/canecas-icon.png"
        ));

        produtos.add(new ProdutoView(
                "Necessaires",
                "Compactas, estilosas e funcionais para o dia a dia.",
                new String[]{"Tecido resistente", "Estampas exclusivas"},
                new String[]{"/images/necessaires/necessaire1.png"},
                new String[]{"Feita à mão"},
                "/images/necessaires-icon.png"
        ));

        produtos.add(new ProdutoView(
                "Bolsas",
                "Bolsas artesanais que unem beleza e utilidade.",
                new String[]{"Design exclusivo", "Feita à mão"},
                new String[]{"/images/bolsas/bolsa1.png"},
                new String[]{"Material sustentável"},
                "/images/bolsas-icon.png"
        ));

        model.addAttribute("produtos", produtos);
        return "produtos";
    }

    @GetMapping("/produtos/{tipo}")
    public String paginaProduto(@PathVariable String tipo, Model model) {
        ProdutoView produto = new ProdutoView();
        List<Testimonial> depoimentos = new ArrayList<>();

        if (tipo.equalsIgnoreCase("canecas")) {
            produto.setTitulo("Canecas Personalizadas");
            produto.setDescricao("Nossas canecas personalizadas combinam praticidade e originalidade...");
            produto.setBeneficios(new String[]{
                "Cerâmica resistente de alta qualidade",
                "Personalização com fotos, nomes ou frases",
                "Opções com alça colorida, glitter ou interior personalizado"
            });
            produto.setImagens(new String[]{
                "/images/canecas/caneca1.png",
                "/images/canecas/caneca2.png",
                "/images/canecas/caneca3.png",
                "/images/canecas/caneca4.png",
                "/images/canecas/caneca5.png",
                "/images/canecas/caneca6.png"
            });

            // --- (Opcional) AQUI você popula legendas/atributos, paralelamente --- 
            produto.setAtributos(new String[]{
                "Imagem 1: vista frontal",
                "Imagem 2: detalhe da alça",
                "Imagem 3: vista lateral",
                "Imagem 4: fundo personalizado",
                "Imagem 5: close na estampa",
                "Imagem 6: embalagem"
            });

            produto.setBanner("/images/canecas-icon.png");

            List<Feature> featuresCanecas = Arrays.asList(
                    new Feature("palette",
                            "Design que Emociona",
                            "Cada design é único e pensado especialmente para você. Trabalhamos com amor para transformar suas ideias em arte."),
                    new Feature("heart",
                            "Qualidade que Dura Gerações",
                            "Materiais premium e técnicas profissionais: cores que não saem, acabamento resistente a micro-ondas e lava-louças."),
                    new Feature("gift",
                            "Embalagem que Surpreende",
                            "A emoção começa antes mesmo de abrir: embalagem exclusiva que destaca cada detalhe."),
                    new Feature("users",
                            "Atendimento Humanizado",
                            "Você não é só mais um cliente: faz parte da nossa família. Acompanhamos seu pedido do início ao fim.")
            );
            produto.setFeatures(featuresCanecas);

            // Depoimentos para "Canecas"
            depoimentos.add(new Testimonial(
                    "Maria Santos",
                    "M",
                    "Hoje 14:32",
                    "“Gente, olha que PERFEITA ficou a caneca da minha mãe! 😭❤️ Ela chorou quando viu. Muito obrigada, ficou exatamente como eu imaginei!”",
                    "/images/Produtos/Caneca/Depoimento 1.png",
                    "green-50",
                    "green-500",
                    null
            ));
            depoimentos.add(new Testimonial(
                    "Ana Clara",
                    "A",
                    "",
                    "“Minha sogra AMOU as frases! Disse que finalmente alguém entende ela 😂 Qualidade incrível!”",
                    "https://images.unsplash.com/photo-1571019613454-1cb2f99b2d8b?w=300&h=200&fit=crop&crop=center",
                    "",
                    "",
                    5
            ));
            depoimentos.add(new Testimonial(
                    "@juliana_mae_de_3",
                    "J",
                    "Stories",
                    "“Gente, que caneca MARAVILHOSA! 100% personalizada, exatamente como eu queria. Recomendo demais! 🥰”",
                    "https://images.unsplash.com/photo-1578662996442-48f60103fc96?w=300&h=200&fit=crop&crop=center",
                    "pink-50",
                    "pink-500",
                    null
            ));
            depoimentos.add(new Testimonial(
                    "Carla Mendes",
                    "C",
                    "",
                    "“O kit ficou LINDO! A embalagem, o cuidado com cada detalhe... Minha mãe se emocionou muito ❤️”",
                    "/images/Produtos/Caneca/caneca mae avo etc.jpeg",
                    "",
                    "",
                    5
            ));
            depoimentos.add(new Testimonial(
                    "Roberta Lima",
                    "R",
                    "Vídeo",
                    "“Fiz um vídeo mostrando como ficou perfeita! Cada detalhe pensado com carinho. Nota 1000!”",
                    "https://images.unsplash.com/photo-1506905925346-21bda4d32df4?w=300&h=200&fit=crop&crop=center",
                    "blue-50",
                    "blue-500",
                    null
            ));
            depoimentos.add(new Testimonial(
                    "Empresa TechCorp",
                    "E",
                    "Email",
                    "“Fizemos 100 canecas personalizadas para o Dia das Mães. Todas as funcionárias ficaram emocionadas! Qualidade excepcional.”",
                    "https://images.unsplash.com/photo-1495474472287-4d71bcdd2085?w=300&h=200&fit=crop&crop=center",
                    "",
                    "",
                    5
            ));

        } else if (tipo.equalsIgnoreCase("necessaires")) {
            produto.setTitulo("Necessaires Personalizadas");
            produto.setDescricao("Nossas necessaires são práticas, duráveis e com estilo único.");
            produto.setBeneficios(new String[]{
                "Tecido reforçado com zíper resistente",
                "Estampas exclusivas e criativas",
                "Ideal para viagens ou organização diária"
            });
            produto.setImagens(new String[]{
                "/images/necessaires/necessaire1.png",
                "/images/necessaires/necessaire2.png",
                "/images/necessaires/necessaire3.png"
            });
            produto.setAtributos(new String[]{
                "Lavável e reutilizável",
                "Produção artesanal e sustentável"
            });
            produto.setBanner("/images/necessaires-icon.png");

            List<Feature> featuresNecessaires = Arrays.asList(
                    new Feature("users",
                            "Praticidade e Estilo",
                            "Compactas e cheias de personalidade: cabe tudo que você precisa para o dia a dia."),
                    new Feature("palette",
                            "Estampas Exclusivas",
                            "Modelos únicos, feitos à mão: cada estampa conta uma história."),
                    new Feature("gift",
                            "Presente Perfeito",
                            "Uma necessaire personalizada é um presente que agrada todos os estilos."),
                    new Feature("heart",
                            "Durabilidade",
                            "Tecido resistente e acabamento impecável: para durar por muito tempo.")
            );
            produto.setFeatures(featuresNecessaires);
            // Depoimentos para "Necessaires"
            depoimentos.add(new Testimonial(
                    "Beatriz Ramos",
                    "B",
                    "Hoje 09:45",
                    "“Minha necessaire chegou perfeita! Adorei cada detalhe.”",
                    "/images/Produtos/Necessaire/depo1.png",
                    "green-50",
                    "green-500",
                    null
            ));
            depoimentos.add(new Testimonial(
                    "Carolina Silva",
                    "C",
                    "",
                    "“A estampa é linda e o material é super resistente. Recomendo muito!”",
                    "/images/Produtos/Necessaire/depo2.png",
                    "",
                    "",
                    4
            ));
            depoimentos.add(new Testimonial(
                    "Fernanda Oliveira",
                    "F",
                    "Stories",
                    "“Usei em uma viagem e minha bolsa nunca ficou tão organizada. Que tiro certeiro!”",
                    "https://images.unsplash.com/photo-1589308078054-8328c3f9a8b1?w=300&h=200&fit=crop&crop=center",
                    "pink-50",
                    "pink-500",
                    null
            ));

        } else if (tipo.equalsIgnoreCase("bolsas")) {
            produto.setTitulo("Bolsas da Tatiart");
            produto.setDescricao("Estilo, utilidade e personalização em cada detalhe.");
            produto.setBeneficios(new String[]{
                "Alças reforçadas",
                "Espaço interno otimizado",
                "Modelos modernos e personalizados"
            });
            produto.setImagens(new String[]{
                "/images/bolsas/bolsa1.png",
                "/images/bolsas/bolsa2.png",
                "/images/bolsas/bolsa3.png"
            });
            produto.setAtributos(new String[]{
                "Confeccionada à mão com carinho",
                "Feita com tecidos resistentes e ecológicos"
            });
            produto.setBanner("/images/bolsas-icon.png");

            List<Feature> featuresBolsas = Arrays.asList(
                    new Feature("users",
                            "Conforto e Praticidade",
                            "Alças reforçadas e design ergonômico para usar o dia todo sem desconforto."),
                    new Feature("sparkles",
                            "Modelos Exclusivos",
                            "Cada bolsa é única: escolha cores, estampas e detalhes que combinam com seu estilo."),
                    new Feature("gift",
                            "Ideal para Presentear",
                            "Perfeita para presentear em datas especiais: design diferenciado e utilidade real."),
                    new Feature("heart",
                            "Sustentabilidade",
                            "Confeccionada com materiais ecológicos e produção artesanal responsável.")
            );
            produto.setFeatures(featuresBolsas);

            // Depoimentos para "Bolsas"
            depoimentos.add(new Testimonial(
                    "Juliana Souza",
                    "J",
                    "Hoje 11:20",
                    "“A bolsa é linda e super prática. Uso para tudo!”",
                    "/images/Produtos/Bolsa/depo1.png",
                    "green-50",
                    "green-500",
                    null
            ));
            depoimentos.add(new Testimonial(
                    "Mariana Lima",
                    "M",
                    "",
                    "“Recebi elogios no trabalho. A qualidade é excepcional.”",
                    "/images/Produtos/Bolsa/depo2.png",
                    "",
                    "",
                    5
            ));
            depoimentos.add(new Testimonial(
                    "Patrícia Andrade",
                    "P",
                    "Stories",
                    "“Leve, espaçosa e muito estilosa. Perfeita para o dia a dia!”",
                    "https://images.unsplash.com/photo-1600180758890-1234abcd5678?w=300&h=200&fit=crop&crop=center",
                    "pink-50",
                    "pink-500",
                    null
            ));

        } else if (tipo.equalsIgnoreCase("mochilas")) {
            produto.setTitulo("Mochilas Personalizadas");
            produto.setDescricao("Funcionalidade e estilo para o dia a dia...");
            produto.setBeneficios(new String[]{
                "Vários tamanhos e modelos",
                "Personalização com nomes e estampas"
            });
            produto.setImagens(new String[]{
                "/images/mochilas/mochila1.png",
                "/images/mochilas/mochila2.png"
            });
            produto.setAtributos(new String[]{
                "Material resistente",
                "Confeccionada à mão"
            });
            produto.setBanner("/images/mochilas-icon.png");

            List<Feature> featuresMochilas = Arrays.asList(
                    new Feature("users",
                            "Espaço Inteligente",
                            "Compartimentos bem distribuídos: cabe tudo sem ficar pesado."),
                    new Feature("heart",
                            "Durabilidade Prolongada",
                            "Material resistente à água e costura reforçada para uso diário."),
                    new Feature("gift",
                            "Perfeita para Presentear",
                            "Um presente útil e personalizado, ideal para estudantes e profissionais."),
                    new Feature("sparkles",
                            "Estilo Moderno",
                            "Disponível em cores e estampas exclusivas criadas pela Tatiart.")
            );
            produto.setFeatures(featuresMochilas);

            // Depoimentos para "Mochilas"
            depoimentos.add(new Testimonial(
                    "Ricardo Santos",
                    "R",
                    "Hoje 08:30",
                    "“Usei em uma trilha e ela aguentou tudo! Muito resistente.”",
                    "/images/Produtos/Mochila/depo1.png",
                    "green-50",
                    "green-500",
                    null
            ));
            depoimentos.add(new Testimonial(
                    "Gabriela Costa",
                    "G",
                    "",
                    "“É perfeita para levar no trabalho e na faculdade. Recomendo 100%!”",
                    "/images/Produtos/Mochila/depo2.png",
                    "",
                    "",
                    5
            ));

        } else if (tipo.equalsIgnoreCase("estojo") || tipo.equalsIgnoreCase("estojos")) {
            produto.setTitulo("Estojo Escolar");
            produto.setDescricao("Estojos personalizados para estudantes de todas as idades.");
            produto.setBeneficios(new String[]{
                "Compartimentos práticos",
                "Fecho em zíper reforçado",
                "Estampas criativas à sua escolha"
            });
            produto.setImagens(new String[]{
                "/images/estojo/estojo1.png",
                "/images/estojo/estojo2.png",
                "/images/estojo/estojo3.png",
                "/images/estojo/estojo4.png"
            });
            produto.setAtributos(new String[]{
                "Bolso interno para canetas",
                "Revestimento impermeável",
                "Alça para transporte",
                "Acabamento reforçado"
            });
            produto.setBanner("/images/estojo-icon.png");

            List<Feature> featuresEstojo = Arrays.asList(
                    new Feature("users",
                            "Organização na Medida",
                            "Múltiplos compartimentos para canetas, lápis e borrachas."),
                    new Feature("shield",
                            "Resistente e Durável",
                            "Materiais de alta qualidade que não rasgam facilmente."),
                    new Feature("gift",
                            "Personalização Exclusiva",
                            "Escolha estampas, cores e nome gravado para deixar único."),
                    new Feature("heart",
                            "Perfeito para Presentear",
                            "Ideal para voltar às aulas com estilo e praticidade.")
            );
            produto.setFeatures(featuresEstojo);

            // Depoimentos para "Estojo"
            depoimentos.add(new Testimonial(
                    "Letícia Fernandes",
                    "L",
                    "Hoje 10:15",
                    "“Isso aqui é um luxo! Coube todas as minhas canetas e mais.”",
                    "/images/Produtos/Estojo/depo1.png",
                    "green-50",
                    "green-500",
                    null
            ));
            depoimentos.add(new Testimonial(
                    "Camila Rocha",
                    "C",
                    "",
                    "“Muito prático e resistente. Já garanti dois para a família inteira.”",
                    "/images/Produtos/Estojo/depo2.png",
                    "",
                    "",
                    5
            ));

        } else if (tipo.equalsIgnoreCase("linha baby") || tipo.equalsIgnoreCase("linhababy")) {
            produto.setTitulo("Linha Baby");
            produto.setDescricao("Peças exclusivas para os primeiros meses do bebê.");
            produto.setBeneficios(new String[]{
                "Tecidos ultra suaves",
                "Tamanho adequado para recém-nascidos",
                "Estampas delicadas e hipoalergênicas"
            });
            produto.setImagens(new String[]{
                "/images/linhababy/baby1.png",
                "/images/linhababy/baby2.png",
                "/images/linhababy/baby3.png"
            });
            produto.setAtributos(new String[]{
                "100% algodão orgânico",
                "Costura reforçada sem irritar a pele",
                "Livre de substâncias químicas"
            });
            produto.setBanner("/images/linhababy-icon.png");

            List<Feature> featuresLinhaBaby = Arrays.asList(
                    new Feature("heart",
                            "Toque Suave",
                            "Tecidos ultra macios que protegem a pele delicada do bebê."),
                    new Feature("users",
                            "Design Seguro",
                            "Costuras reforçadas e sem peças pequenas que possam se soltar."),
                    new Feature("gift",
                            "Kit Completo",
                            "Conjunto de body, touca e mantinha para presentear com carinho."),
                    new Feature("sparkles",
                            "Antialérgico",
                            "Certificado livre de substâncias tóxicas e hipoalergênico.")
            );
            produto.setFeatures(featuresLinhaBaby);

            // Depoimentos para "Linha Baby"
            depoimentos.add(new Testimonial(
                    "Mariana Alves",
                    "M",
                    "Hoje 07:50",
                    "“As roupinhas são incríveis, super macias. Meu bebê usa 24 horas por dia!”",
                    "/images/Produtos/LinhaBaby/depo1.png",
                    "green-50",
                    "green-500",
                    null
            ));
            depoimentos.add(new Testimonial(
                    "Ana Paula",
                    "A",
                    "",
                    "“Comprei um body e um macacãozinho: não largo mais! Ótima qualidade.”",
                    "/images/Produtos/LinhaBaby/depo2.png",
                    "",
                    "",
                    5
            ));

        } else {
            return "redirect:/produtos";
        }

        model.addAttribute("produto", produto);
        model.addAttribute("depoimentos", depoimentos);
        model.addAttribute("etapas", gerarEtapasPadrao());
        model.addAttribute("personalizacoes", gerarPersonalizacoesPadrao());

        // CtaFinal dinâmico
        CtaFinal cta = new CtaFinal();
        cta.setTitulo("Não Deixe Esse Momento Passar...");
        cta.setDescricaoHtml("<strong>A vida é feita de momentos únicos.</strong> Que tal transformar o próximo em uma lembrança eterna? Sua " + produto.getTitulo().toLowerCase() + " personalizada está a apenas um clique de distância. <strong>Vamos criar magia juntos?</strong>");
        cta.setTextoBotaoPrincipal("❤️ SIM! Quero Criar Minha " + produto.getTitulo() + " Agora");
        cta.setTextoBotaoWhatsapp("📱 Falar no WhatsApp");
        cta.setInfoEntrega("<strong>Entrega rápida</strong> em 3-5 dias");
        cta.setInfoSatisfacao("<strong>Satisfação</strong> 100% garantida");
        cta.setInfoAtendimento("<strong>Atendimento</strong> humanizado");
        cta.setAlertaPrazo("⚡ <strong>ATENÇÃO:</strong> Devido à alta demanda, estamos com prazo de entrega de 3-5 dias. Garanta já a sua antes que o prazo aumente!");

        model.addAttribute("cta", cta);
        return "produto";
    }

    private List<Personalizacao> gerarPersonalizacoesPadrao() {
        return List.of(
                new Personalizacao(
                        "Para Mães e Avós", "heart", "pink-100", "pink-600",
                        List.of(
                                "Datas especiais (nascimento dos filhos/netos)",
                                "Frases marcantes que toda mãe fala",
                                "Fotos da família",
                                "Mensagens de amor dos filhos",
                                "Desenhos das crianças"
                        )
                ),
                new Personalizacao(
                        "Casais e Relacionamentos", "users", "blue-100", "blue-600",
                        List.of(
                                "Data do primeiro encontro",
                                "Fotos do casal",
                                "Frases especiais entre vocês",
                                "Coordenadas de lugares importantes",
                                "Linha do tempo do relacionamento"
                        )
                ),
                new Personalizacao(
                        "Motivacional", "sparkles", "green-100", "green-600",
                        List.of(
                                "Frases inspiradoras personalizadas",
                                "Metas e objetivos",
                                "Versículos bíblicos",
                                "Mantras pessoais",
                                "Conquistas e vitórias"
                        )
                ),
                new Personalizacao(
                        "Datas Especiais", "gift", "purple-100", "purple-600",
                        List.of(
                                "Aniversários únicos",
                                "Formaturas e conquistas",
                                "Aposentadoria",
                                "Nascimento de bebês",
                                "Bodas e aniversários de casamento"
                        )
                ),
                new Personalizacao(
                        "Profissional", "coffee", "orange-100", "orange-600",
                        List.of(
                                "Logo da empresa",
                                "Nome e cargo personalizado",
                                "Brindes corporativos",
                                "Eventos e convenções",
                                "Presentes para equipe"
                        )
                ),
                new Personalizacao(
                        "Arte Personalizada", "palette", "red-100", "red-600",
                        List.of(
                                "Ilustrações exclusivas",
                                "Retratos artísticos",
                                "Pets e animais de estimação",
                                "Paisagens especiais",
                                "Arte abstrata personalizada"
                        )
                )
        );
    }

}
