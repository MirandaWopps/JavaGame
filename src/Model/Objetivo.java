package Model;

public class Objetivo {

	
	public enum ListaObjetivos {
		
	    Objetivo1("Conquistar na totalidade a EUROPA, a OCEANIA e mais um terceiro."),
	    Objetivo2("Conquistar na totalidade a ÁSIA e a AMÉRICA DO SUL."),
	    Objetivo3("Conquistar na totalidade a EUROPA, a AMÉRICA DO SUL e mais um terceiro."),
	    Objetivo4("Conquistar 18 TERRITÓRIOS e ocupar cada um deles com pelo menos dois exércitos."),
	    Objetivo5("Conquistar na totalidade a ÁSIA e a ÁFRICA."),
	    Objetivo6("Conquistar na totalidade a AMÉRICA DO NORTE e a ÁFRICA."),
	    Objetivo7("Conquistar 24 TERRITÓRIOS à sua escolha."),
	    Objetivo8("Conquistar na totalidade a AMÉRICA DO NORTE e a OCEANIA."),
	    Objetivo9("Destruir totalmente OS EXÉRCITOS AZUIS."),
	    Objetivo10("Destruir totalmente OS EXÉRCITOS AMARELOS."),
	    Objetivo11("Destruir totalmente OS EXÉRCITOS VERMELHOS."),
	    Objetivo12("Destruir totalmente OS EXÉRCITOS PRETOS."),
	    Objetivo13("Destruir totalmente OS EXÉRCITOS BRANCOS."),
	    Objetivo14("Destruir totalmente OS EXÉRCITOS VERDES.");

		
		private String descricao;

	    ListaObjetivos(String descricao) {
	        this.descricao = descricao;
	    }
	    
	    public String getDescricao() {
	        return descricao;
	    }
	    
	   
	   
	}
	
	
	
	
}