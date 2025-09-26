package hogwarts.domain.models;

public enum NivelFeitico {
    BASICO("Básico", "Feitiços simples, aprendidos nos primeiros anos"),
    INTERMEDIARIO("Intermediário","Feitiços com efeitos mais fortes ou complexos"),
    AVANCADO("Avançado","Magias poderosas, exigem domínio técnico"),
    PROIBIDO("Proibido", "Magias das Artes das Trevas ou restritas"),
    LEGENDARIO("Legendário", "Feitiços raros, quase mitológicos");

    private final String nome;
    private final String descricao;

    NivelFeitico(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }
}

