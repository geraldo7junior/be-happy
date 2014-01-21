package mod.jogos;

public class ComplexidadeNivel {
	
	public Integer memoriaParaMemoria(Integer nivel, Integer tentativas, Integer acertos, Integer x, Integer y){
		if ((tentativas <= (x*y+4)) && (acertos == x*y)){
			if (verificarNivel(nivel,x,y)){
				return nivel+1;
			}
			return nivel;
		}
		else return nivel;
	}
	
	public boolean memoriaParaForca(Integer tentativas, Integer x, Integer y){
		if (tentativas <= (x*y)){
			return true;
		}
		else return false;
	}
	
	public boolean verificarNivel(Integer nivel, Integer x, Integer y){
		if (x==4 && y==4 && nivel < 2){
			return true;
		}
		else if (x==4 && y==5 && nivel < 3){
			return true;
		}
		else if (x==4 && y==6 && nivel < 4){
			return true;
		}
		else if (x==5 && y==6 && nivel < 5){
			return true;
		}
		else return false;
	}

}
