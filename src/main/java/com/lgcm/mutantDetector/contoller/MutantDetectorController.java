package com.lgcm.mutantDetector.contoller;
/**
 * @author lgerardocv@gmail.com
 * Controller for web services
 */
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.lgcm.mutantDetector.domain.DNASerie;
import com.lgcm.mutantDetector.domain.Stats;
import com.lgcm.mutantDetector.services.MutantDetectorService;

@CrossOrigin(origins="*")
@RestController
public class MutantDetectorController {
	@Autowired
	private MutantDetectorService MutantDetectorService;
	
	@PostMapping(value="mutant",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> SaveMutant(@RequestBody DNASerie dna) throws Exception{
		if(dna.getDna()==null||dna.getDna().length==0) {
			throw new Exception("Wrong input format");
		}
		boolean is_mutant=MutantDetectorService.registerPerson(dna.getDna());
		if(is_mutant) {
			Map<String, Object> map = new HashMap<String, Object>();
	        map.put("status", "Saved");
	        map.put("detail", "Is Mutant");
	        return new ResponseEntity<Object>(map,HttpStatus.ACCEPTED);
		}
		else {
			Map<String, Object> map = new HashMap<String, Object>();
	        map.put("status", "Saved");
	        map.put("detail", "Isn't Mutant");
	        return new ResponseEntity<Object>(map,HttpStatus.FORBIDDEN);
		}
	}
	
	@GetMapping(value="stats",produces=MediaType.APPLICATION_JSON_VALUE)
	public Stats GetStats(){
		return MutantDetectorService.getStats();
		/*Map<String, Object> map = new HashMap<String, Object>();
        map.put("count_mutant_dna", "Saved");
        map.put("count_human_dna", "Is Mutant");
        map.put("ratio", "Is Mutant");
        return new ResponseEntity<Object>(map,HttpStatus.ACCEPTED);*/
	}
}
