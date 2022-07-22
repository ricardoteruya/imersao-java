
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.awt.Color;
import java.awt.Font;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {
	
	public void cria(InputStream inputStream, String nomeArquivo) throws Exception{
		
		BufferedImage imagemOriginal = ImageIO.read(inputStream);
		
		// cria nova imagem em memoria com transparencia e com tamanho novo
		// identificar altura e largura
		int largura = imagemOriginal.getWidth();
		int altura = imagemOriginal.getHeight();
		int novaAltura = altura + 200;
		BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
		
		// copiar a imagem original para nova imagem (em memoria)
		Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
		graphics.drawImage(imagemOriginal, 0, 0, null);
				
		//configurar a fonte
		var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
		graphics.setColor(Color.YELLOW);
		graphics.setFont(fonte);
		
		// escrever uma frase na nova imagem
		graphics.drawString("TOPZERA", 100, novaAltura - 100);
		
		// escrever nova imagem em arquivo
		ImageIO.write(novaImagem, "png", new File(nomeArquivo));
	}
	
// Teste
//	public static void main(String[] args) throws Exception{
//		var geradora = new GeradoraDeFigurinhas();
//		geradora.cria(
//				new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_UX128_CR0"
//						).openStream(),
//				"figurinha.png"
//		);
//	}
	
}
