package com.dawes;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dawes.modelo.EtiquetaPostVO;
import com.dawes.modelo.PostVO;
import com.dawes.service.ServicioEtiqueta;
import com.dawes.service.ServicioEtiquetaPost;
import com.dawes.service.ServicioPost;

@SpringBootTest
class PreparacionApplicationTests {
	@Autowired
	ServicioPost sep;
	
	@Autowired
	ServicioEtiquetaPost sepet;
	
	
	@Test
	void contextLoads() {		
		Optional<PostVO> e = sep.findById(5);
		Iterable<EtiquetaPostVO> et = sep.findById(5).get().getEtiquetapost();
		for(EtiquetaPostVO eti : et)
			sepet.delete(eti);
		System.out.println(e.get().getTitulo());
		sep.delete(e.get());
	}

}
