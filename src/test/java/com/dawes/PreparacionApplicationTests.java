package com.dawes;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dawes.modelo.EtiquetaPostVO;
import com.dawes.service.ServicioEtiquetaPost;

@SpringBootTest
class PreparacionApplicationTests {
	@Autowired
	ServicioEtiquetaPost sep;
	
	@Test
	void contextLoads() {
		Optional<EtiquetaPostVO> e = sep.findById(2);
		System.out.println(e.get().toString());
		//sep.delete(e.get());
	}

}
