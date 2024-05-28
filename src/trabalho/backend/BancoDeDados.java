package trabalho.backend;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import trabalho.dominio.Local;
import trabalho.dominio.Organizacao;
import trabalho.dominio.PersistenceService;
import trabalho.dominio.Usuario;
public class BancoDeDados implements PersistenceService{

	private static Map<String, Usuario> mapaUsuario = 
			new HashMap<String, Usuario>();
	private static Map<String, Organizacao> mapaOrganizacao =
			new HashMap<String, Organizacao>(); 
	private static HashMap<Integer, Local> mapaLocal = 
			new HashMap<Integer, Local>();
	
			

	public BancoDeDados() {
		inicializa();
	}
	public static void main(String[] args) {
		inicializa();
	}
 
	
	public static void inicializa() {
		//Cria Usuarios no "Banco"
		Usuario usuario1 = new Usuario(1, "Kaká","14602053670","420","xkakaxd@gmail.com","Rua Ja To Inno,80-Barreiro","8/10/1999",'1');
		Usuario usuario2 = new Usuario(2, "Luis","11111111111","123","luis@email.com","Rua dos Pássaros,123-Bairro Alto da Serra","14/12/1979",'1');
		Usuario usuario3 = new Usuario(3, "Giovanni","22222222222","123","giovanni@email.com","Avenida dos Astronautas, 456-Condomínio Estrela Cadente, Bloco C, Apto 302","28/07/1989",'2');
		Usuario usuario4 = new Usuario(4, "Wanderleco","33333333333","123", "wandeco@email.com,","Avenida dos Girassóis, 456-Bairro Vista Bela","4/07/2000",'0');
		Usuario usuario5 = new Usuario(5, "Rodrigo","44444444444","123","roddoido@gmail.com","Rua das Flores, 123, Cidade Feliz, Estado da Alegria","15/07/1990",'1');
		
		//Cria as Organizações
		Organizacao organizacao1 = new Organizacao(1, "Empresa ABC", "12345678901234", "Rua das Flores, 123", "contato@empresa.com");
		Organizacao organizacao2 = new Organizacao(2, "Soluções TechGenius", "98765432109876", "Avenida Central, 456", "contato@techgenius.com");
		Organizacao organizacao3 = new Organizacao(3, "InovaSoftwares", "24681012141618", "Rua dos Programadores, 789", "contato@inovasoft.com");
		Organizacao organizacao4 = new Organizacao(4, "Widgets World", "31415926535897", "Avenida dos Gadgets, 101", "contato@widgetsworld.com");
		Organizacao organizacao5 = new Organizacao(5, "DreamWorks Inc.", "57575757575757", "Rua da Imaginação, 2020", "contato@dreamworks.com");
		
		//Cria Locais
		Local local1 = new Local(1, "Salão de Festas Alegria", "ambiente coberto", "Rua das Flores", "Centro", "123", "Cidade Feliz", "MG", "Grande salão com decoração colorida", 200, "Pista de dança, área para buffet");
		Local local2 = new Local(2, "Praça da Liberdade", "ambiente aberto", "Avenida Central", "Bairro Alto", "456", "Cidade Livre", "DF", "Praça arborizada com bancos e áreas de recreação", 500, "Playground, quadra esportiva");
		Local local3 = new Local(3, "Teatro Municipal", "ambiente fechado", "Rua dos Artistas", "Centro", "789", "Cidade Cultural", "RJ", "Espaço para apresentações artísticas e culturais", 300, "Palco, camarins");
		Local local4 = new Local(4, "Chácara do Lago Azul", "ambiente aberto", "Estrada da Paz", "Bairro Tranquilo", "101", "Cidade Serena", "SP", "Área de lazer com lago e jardins", 100, "Espaço para cerimônias ao ar livre, churrasqueira");
		Local local5 = new Local(5, "Centro de Convenções Estrela", "ambiente fechado", "Avenida dos Congressos", "Bairro Empresarial", "202", "Cidade Global", "MG", "Moderno centro de convenções com várias salas e auditórios", 1000, "Salas de reunião, espaço para exposições");
		
		//Mapeia os Usuarios
		mapaUsuario.put(usuario1.getCpf(), usuario1);
		mapaUsuario.put(usuario2.getCpf(), usuario2);
		mapaUsuario.put(usuario3.getCpf(), usuario3);
		mapaUsuario.put(usuario4.getCpf(), usuario4);
		mapaUsuario.put(usuario5.getCpf(), usuario5);
		System.out.println(mapaUsuario);
		
		//Mapeia os Usuarios
		mapaOrganizacao.put(organizacao1.getCnpj(), organizacao1);
		mapaOrganizacao.put(organizacao2.getCnpj(), organizacao2);
		mapaOrganizacao.put(organizacao3.getCnpj(), organizacao3);
		mapaOrganizacao.put(organizacao4.getCnpj(), organizacao4);
		mapaOrganizacao.put(organizacao5.getCnpj(), organizacao5);
		System.out.println(mapaOrganizacao);
		
		//Mapeia os Locais
		mapaLocal.put(local1.getIdLocal(), local1);
		mapaLocal.put(local2.getIdLocal(), local2);
		mapaLocal.put(local3.getIdLocal(), local3);
		mapaLocal.put(local4.getIdLocal(), local4);
		mapaLocal.put(local5.getIdLocal(), local5);
		System.out.println(mapaLocal);
	}
	
    public <T> List<T> listarElementos(Class<T> clazz) {
    	// Lista para armazenar os elementos a serem retornados
        List<T> lista = new ArrayList<>();
        
        // Switch case para determinar o tipo de classe e adicionar os elementos correspondentes à lista
        switch (clazz.getSimpleName()) { //  Este método retorna o nome simples da classe representada pelo objeto
            case "Usuario":
                // Caso a classe for Usuario, percorre o mapa de usuários e adiciona cada usuário à lista
                for (Usuario usuario : mapaUsuario.values()) {
                    lista.add(clazz.cast(usuario));
                }
                break;
            case "Organizacao":
                // Caso a classe for Organizacao, percorre o mapa de organizações e adiciona cada organização à lista
                for (Organizacao organizacao : mapaOrganizacao.values()) {
                    lista.add(clazz.cast(organizacao));
                }
                break;
            case "Local":
                // Caso a classe for Local, percorre o mapa de locais e adiciona cada local à lista
                for (Local local : mapaLocal.values()) {
                    lista.add(clazz.cast(local));
                }
                break;
            default:
                // Se a classe não for reconhecida, lança uma exceção ou retorna uma lista vazia, conforme necessário
                throw new IllegalArgumentException("Classe não suportada: " + clazz.getSimpleName());
        }
        
        // Retorna a lista contendo os elementos solicitados
        return lista;
    }
    
    
	@Override
	public <T> T recupera(String key) {
		return (T) mapaUsuario.get(key);
				
	}


}
