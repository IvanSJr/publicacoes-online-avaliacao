package com.publicacoesonline.avaliacaodesenvolvedor;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.publicacoesonline.avaliacaodesenvolvedor.entities.Processo;
import com.publicacoesonline.avaliacaodesenvolvedor.entities.Reu;
import com.publicacoesonline.avaliacaodesenvolvedor.entities.Usuario;
import com.publicacoesonline.avaliacaodesenvolvedor.repositories.ProcessoRepository;
import com.publicacoesonline.avaliacaodesenvolvedor.repositories.ReuRepository;
import com.publicacoesonline.avaliacaodesenvolvedor.repositories.UsuarioRepository;

@SpringBootApplication
public class Avaliacaodesenvolvedor1Application implements CommandLineRunner{

	@Autowired
	private ReuRepository reuRepository;
	
	@Autowired
	private ProcessoRepository processoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Avaliacaodesenvolvedor1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Usuario us1 = new Usuario(null, "Ivan Santos de Jesus Júnior", "ivanjrjesus01@gmail.com", "123junior");
		Usuario us2 = new Usuario(null, "Carmen Gomes Santos de Jesus", "carmenjesus01@gmail.com", "210521*jo");
		Usuario us3 = new Usuario(null, "Felipe da Cruz Soares", "felipesoa27@gmail.com", "felipE123789");
		Usuario us4 = new Usuario(null, "Evandro Matosinhos Castelhano", "evand1001@gmail.com", "vand15*caste");
		Usuario us5 = new Usuario(null, "Adrien Portugal ", "adrien1532@gmail.com", "adrienlagutroP");
		Usuario us6 = new Usuario(null, "Cheila Flores ", "cheila.girassol@gmail.com", "lirio.vale123");
		Usuario us7 = new Usuario(null, "Alexa Lemes Sousa", "alexa.amazon@gmail.com", "55alexa27*06");
		Usuario us8 = new Usuario(null, "Matheus Peçanha Farinha", "theuspeçanha11@gmail.com", "lie*joe55");
		Usuario us9 = new Usuario(null, "Chloé Dutra Vilaverde", "chloe827@gmail.com", "Chloé.2706");
		Processo proc1 = new Processo(null, 500, us1);
		Processo proc2 = new Processo(null, 501, us2);
		Processo proc3 = new Processo(null, 502, us2);
		Processo proc4 = new Processo(null, 503, us3);
		Processo proc5 = new Processo(null, 504, us3);
		Processo proc6 = new Processo(null, 505, us4);
		Processo proc7 = new Processo(null, 506, us5);
		Processo proc8 = new Processo(null, 507, us6);
		Processo proc9 = new Processo(null, 508, us6);
		Processo proc10 = new Processo(null, 509, us6);
		Reu reu1 = new Reu(null, "Ivan Júnior", "080.624.135-78", proc1);
		Reu reu2 = new Reu(null, "Evellyn Monteiro", "757.787.388-89", proc1);
		Reu reu3 = new Reu(null, "Ivan Santos", "641.224.630-41", proc2);
		Reu reu4 = new Reu(null, "João Victor", "346.524.156-80", proc2);
		Reu reu5 = new Reu(null, "Carlos Ramos", "432.448.421-00", proc2);
		Reu reu6 = new Reu(null, "Carmen Gomes", "132.292.664-63", proc2);
		Reu reu7 = new Reu(null, "Giulia Bento Passos", "387.162.634-13", proc3);
		Reu reu8 = new Reu(null, "Jimmy Sandinha", "230.942.986-48", proc3);
		Reu reu9 = new Reu(null, "Zilda Simas", "851.147.544-32", proc3);
		Reu reu10 = new Reu(null, "Kiari Miranda", "560.172.988-36", proc4);
		Reu reu11 = new Reu(null, "Agostinho Barra", "088.875.940-15", proc5);
		Reu reu12 = new Reu(null, "Ravi Lamenha", "306.066.960-08", proc6);
		Reu reu13 = new Reu(null, "Aarnav Ourique", "456.227.380-16", proc7);
		Reu reu14 = new Reu(null, "Mónica Castilho", "478.443.640-50", proc8);
		Reu reu15 = new Reu(null, "Martin Machado", "611.196.440-20", proc8);
		Reu reu16 = new Reu(null, "Yaroslav Malho", "062.234.140-56", proc9);
		Reu reu17 = new Reu(null, "Dominika Taborda", "712.485.050-93", proc10);

		us1.getProcesso().addAll(Arrays.asList(proc1));
		us2.getProcesso().addAll(Arrays.asList(proc2, proc3));
		us3.getProcesso().addAll(Arrays.asList(proc4));
		us4.getProcesso().addAll(Arrays.asList(proc6));
		us5.getProcesso().addAll(Arrays.asList(proc7));
		us6.getProcesso().addAll(Arrays.asList(proc8, proc9));
		proc1.getReus().addAll(Arrays.asList(reu1, reu2));
		proc2.getReus().addAll(Arrays.asList(reu3, reu4, reu5, reu6));
		proc3.getReus().addAll(Arrays.asList(reu7, reu8, reu9));
		proc4.getReus().addAll(Arrays.asList(reu10));
		proc5.getReus().addAll(Arrays.asList(reu11));
		proc6.getReus().addAll(Arrays.asList(reu12));
		proc7.getReus().addAll(Arrays.asList(reu13));
		proc8.getReus().addAll(Arrays.asList(reu14, reu15));
		proc9.getReus().addAll(Arrays.asList(reu16));
		proc10.getReus().addAll(Arrays.asList(reu17));
		usuarioRepository.saveAll(Arrays.asList(us1, us2, us3, us4, us5, us6, us7, us8, us9));
		processoRepository.saveAll(Arrays.asList(proc1, proc2, proc3, proc4, proc5, proc6, proc7, proc8, proc9, proc10));
		reuRepository.saveAll(Arrays.asList(reu1, reu2, reu3, reu4, reu5, reu6, reu7, reu8, reu9, reu10, reu11, reu12, reu13, reu14, reu15, reu16, reu17));
		
	}

}
