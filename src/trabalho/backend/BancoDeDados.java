package trabalho.backend;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import trabalho.dominio.PersistenceService;
import trabalho.dominio.Usuario;
public class BancoDeDados implements PersistenceService{

	private static Map<String, Object> mapa = 
			new HashMap<String, Object>();

	public BancoDeDados() {
		inicializa();
	}
	public static void main(String[] args) {
		inicializa();
	}
 
	
	public static void inicializa() {
		Usuario usuario1 = new Usuario(1, "Kaká","14602053670","321","xkakaxd@gmail.com","Rua Ja To Inno,80-Barreiro","8/10/1999",'1');
		Usuario usuario2 = new Usuario(2, "Luis","11111111111","123","luis@email.com","Rua dos Pássaros,123-Bairro Alto da Serra","14/12/1979",'1');
		Usuario usuario3 = new Usuario(3, "Giovanni","22222222222","123","giovanni@email.com","Avenida dos Astronautas, 456-Condomínio Estrela Cadente, Bloco C, Apto 302","28/07/1989",'2');
		Usuario usuario4 = new Usuario(4, "Wanderleco","33333333333","123", "wandeco@email.com,","Avenida dos Girassóis, 456-Bairro Vista Bela","4/07/2000",'0');
		Usuario usuario5 = new Usuario(5, "Rodrigo","44444444444","123","roddoido@gmail.com","Rua das Flores, 123, Cidade Feliz, Estado da Alegria","15/07/1990",'1');
		
		mapa.put(usuario1.getCpf(), usuario1);
		mapa.put(usuario2.getCpf(), usuario2);
		mapa.put(usuario3.getCpf(), usuario3);
		mapa.put(usuario4.getCpf(), usuario4);
		mapa.put(usuario5.getCpf(), usuario5);
		System.out.println(mapa);
	}
	
    public <T> List<T> listarElementos(Class<T> clazz) {
        List<T> lista = new ArrayList<>();
        for (Object objeto : mapa.values()) {
            if (clazz.isInstance(objeto)) {
                lista.add(clazz.cast(objeto));
            }
        }
        return lista;
    }
    
    
	@Override
	public <T> T recupera(String key) {
		return (T) mapa.get(key);
	}
	@Override
	public <T> T grava(String key, Object o) {
		return (T) mapa.put(key, o);
	}
	
	public void apagar(String key, Object o) {
		mapa.remove(key);
	}

}
