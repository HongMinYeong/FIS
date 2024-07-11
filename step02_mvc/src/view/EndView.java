package view;

import java.util.ArrayList;

import model.domain.PeopleDTO;

public class EndView {

	public static void printAll(ArrayList<PeopleDTO> all) {
		
		// ArrayList 안에 있는 모든 PeopleDTO 출력하기 
		for(PeopleDTO x :all ) {
			
			System.out.println(x.getName());
		}
		
	}


}
