package br.com.cobello.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cobello.service.AESService;

/**
 * API
 * @author Felipe
 *
 */
@RestController
@RequestMapping("v1")
public class AESAPI 
{
	@Autowired
	AESService service;
	
	@GetMapping("encrypt/{data}")
	public String encrypt(@PathVariable String data)
	{
		return service.encrypt(data);
	}
	
	@GetMapping("decrypt/{data}")
	public String decrypt(@PathVariable String data)
	{
		return service.decrypt(data);
	}

}
