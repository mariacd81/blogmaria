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
import com.dawes.service.ServicioRol;

@SpringBootTest
class PreparacionApplicationTests {
	@Autowired
	ServicioPost sep;
	
	@Autowired
	ServicioRol sepet;
	
	
	@Test
	void contextLoads() {		
		
		System.out.println(sepet.findById(2).get().getRoleName());
	}

}
