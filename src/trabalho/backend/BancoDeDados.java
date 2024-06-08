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
		Usuario usuario1 = new Usuario(1, "Kaká","14602053670","321","xkakaxd@gmail.com","31995290543","8/10/1999",'1','1');
		Usuario usuario2 = new Usuario(2, "Luis","11111111111","123","luis@email.com","31995290543","14/12/1979",'1','2');
		Usuario usuario3 = new Usuario(3, "Giovanni","22222222222","123","giovanni@email.com","31995290543","28/07/1989",'2','3');
		Usuario usuario4 = new Usuario(4, "Wanderleco","33333333333","123", "wandeco@email.com,","31995290543","4/07/2000",'0','3');
		Usuario usuario5 = new Usuario(5, "Sândalo","44444444444","123","bessa@gmail.com","31995290543","15/07/1990",'1','0');
		
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
	/* @Override
	    public <T> T atualiza(String key, Object o) {
	        if (database.containsKey(key)) {
	            database.put(key, o);
	            return (T) o;
	        }
	        return null; // ou lançar uma exceção se o registro não existir
		}		*/   
	@Override
	    public <T> T atualiza(String key, Object o) {
	        if (mapa.containsKey(key)) {
	            mapa.put(key, o);
	            return (T) o;
	        }
	        return null; // ou lançar uma exceção se o registro não existir
	    }
	public void apagar(String key, Object o) {
		mapa.remove(key);
	}
	

}
