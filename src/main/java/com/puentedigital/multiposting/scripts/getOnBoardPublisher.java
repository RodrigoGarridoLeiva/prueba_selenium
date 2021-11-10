package com.puentedigital.multiposting.scripts;
import com.puentedigital.multiposting.scripts.myfunctions;

public class getOnBoardPublisher {
	
	myfunctions functions = new myfunctions();
	
	private String username = "rodrigo@puente.digital";
	private String password = "MrMisterio#1803";
	private String url_base = "https://www.getonbrd.com/members/auth/login";
	private String url_new_vacancy = "https://www.getonbrd.com/jobs/new";
	
	public void init() {
	
		functions.init();
	};
	
	public void setup() {
		
		System.out.println("ejecutando setup de GetOnBoardPublisher");
		
	};
	
	public void authenticate() throws InterruptedException {
		
		System.out.println("ejecutando autenticación de GetOnBoardPublisher");
		functions.maximize_window();
		functions.navigate(url_base);
		functions.fill_input("//input[@id='team_member_email']", username);
		functions.fill_input("//input[@id='team_member_password']", password);
		functions.click("//input[@name='commit']");
			
	};
	
	public void new_vacancy() {
		
		System.out.println("generando nueva vacante en GetOnBoardPublisher");
        functions.navigate(url_new_vacancy);
		
	};
	
	public void close() {
		
		functions.close();
		
	};
	
	public void fill_vacancy() throws InterruptedException {
		
		//Titulo de trabajo
		functions.fill_input("//input[@id='job_title']", "Desarrollador Java/Unix");
		
		//Jornada
		String jornada = "1";
		functions.select_by_value("//select[contains(@id,'job_modality_id')]", jornada);
		
		//Nivel Experiencia
		String nivel = "3";
		String experience_xpath = "";
		
		if(nivel=="1")
            experience_xpath = "//label[@id='label_for_job_seniority_1']"; //Sin experiencia

        if(nivel=="2")
            experience_xpath = "//label[@id='label_for_job_seniority_']"; //#Junior

        if(nivel=="3")
            experience_xpath = "//label[@id='label_for_job_seniority_3']"; //SemiJunior

        if(nivel=="4")
            experience_xpath = "//label[@id='label_for_job_seniority_4']"; //Senior

        if(nivel=="5")
            experience_xpath = "//label[@id='label_for_job_seniority_5']"; //Expert

        functions.click(experience_xpath);
        
        //Modalidad Remota
        String modalidad = "2";
        String remote_xpath = "";
        
        if(modalidad=="1")
            remote_xpath = "//label[@for='job_remote_modality_no_remote']"; //Completamente presencial
        
        if(modalidad=="2")
            remote_xpath = "//label[@for='job_remote_modality_temporarily_remote']"; //Temporalmente remoto
        
        if(modalidad=="3")
            remote_xpath = "//label[@for='job_remote_modality_remote_local']"; //Remoto pero debe residir en el pais

        if(modalidad=="4")
            remote_xpath = "//label[@for='job_remote_modality_fully_remote']"; //Completamente remoto
		
        functions.click(remote_xpath);
        
        
        //Rango Salarial - REVISAR EXECUTE SCRIPT NO FUNCIONA
        long rangoMinimo = 2900;
        long rangoMaximo = 3200;
        
        if(jornada!="2" && jornada!="3") { //Se busca que sea diferente a las jornadas seleccionadas, ya que con estas no incluyen rango salarial.
        		String ArgMin = "arguments[0].value = " + String.valueOf(rangoMinimo-100) + ";";
        		String ArgMax = "arguments[0].value = " +  String.valueOf(rangoMaximo) + ";";
        		
        		functions.execute_script(ArgMin, "//input[@id='job_min_salary']");
        		functions.execute_script(ArgMax, "//input[@id='job_max_salary']" );
        };
        
        functions.key_up("//input[@id='job_min_salary']");
        
        String cuerpo = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
        
        //Introduce tu compañia
        functions.fill_input("//trix-editor[@input='trix-editor--projects']", cuerpo);
        functions.pause(2);
        
        //Funciones del trabajo
        functions.fill_input("//trix-editor[@input='trix-editor--functions']", cuerpo);
        functions.pause(2);
        
        //Experiencia requerida
        functions.fill_input("//trix-editor[@input='trix-editor--description']", cuerpo);
        functions.pause(2);
        
        //Experiencia opcional
        functions.fill_input("//trix-editor[@input='trix-editor--desirable']", cuerpo);
        functions.pause(2);
        
        //Beneficios escritos
        functions.fill_input("//trix-editor[@input='trix-editor--benefits']", cuerpo);
        functions.pause(2);
        
        //Reclutando para otra empresa - Other element recive the click
        boolean Reclutando_para_otra_empresa = true;
        System.out.println("Reclutando");
        
        if(Reclutando_para_otra_empresa) {
            //Click al check
            functions.click("//input[@id='recruiting-on-behalf']");
            functions.pause(2);
            functions.fill_input("//input[@id='job_hiring_company']", "TCS");
            functions.fill_input("//input[@id='job_hiring_company_website']", "https://www.tcs.com/");
        };
        
        //Confidencialidad del empleo
        boolean confidencial = true;
        System.out.println("Confidencial");
        
        if(confidencial) {
        	functions.click("//input[@id='job_confidential']");
        };
        
        //Salario Publico
        boolean public_salary = true;
        System.out.println("salario publico");
        
        if(public_salary && (jornada!="2" && jornada!="3")) { //Cuando la jornada es 2 o 3, el salario no aparece
        	functions.click("//input[@id='job_confidential']");
        };
        
        //Idioma
        System.out.println("idioma");
        String idioma = "es";
        functions.select_by_value("//select[@id='job_lang']",idioma);
        
        //Seleccionar Beneficios
        System.out.println("Beneficios");
        int[] perks = {1, 5, 9, 10, 29};
        functions.pause(2);
        functions.click("//a[@href='#all-benefits']");
        
        for(int i=0; i<perks.length; i++) {
        	
        	if(perks[i]==1){
            	
            	functions.click("//input[@id='job_perks_flexible_hours']");
                functions.pause(1);
            };
            
            if(perks[i]==2) {
            	
            	functions.click("//input[@id='job_perks_informal_dresscode']");
                functions.pause(1);
            	
            };
            
            if(perks[i]==3) {
            	
            	functions.click("//input[@id='job_perks_pet_friendly']");
                functions.pause(1);
            	
            };
            
            if(perks[i]==4) {
            	
            	functions.click("//input[@id='job_perks_health_coverage']");
                functions.pause(1);
            };
            
            if(perks[i]==5) {
            	
            	functions.click("//input[@id='job_perks_vacation_over_legal']");
                functions.pause(1);
            	
            };
            
            if(perks[i]==6) {
            	
            	//JOBS REMOTE OPTIONAL NOT FOUND
            };
            
            if(perks[i]==7) {
            	
            	functions.click("//input[@id='job_perks_computer_provided']");
                functions.pause(1);
            	
            };
            
            if(perks[i]==8) {
            	
            	functions.click("//input[@id='job_perks_accessible']");
                functions.pause(1);
            	
            };
            
          
            if(perks[i]==9) {
            	
            	functions.click("//input[@id='job_perks_bicycle_parking']");              
                functions.pause(1);
            	
            };
            
            if(perks[i]==10) {
            	
                functions.click("//input[@id='job_perks_childcare']");
                functions.pause(1);
            	
            };
            
            if(perks[i]==11) {
            	
            	functions.click("//input[@id='job_perks_commuting_buses']");
                functions.pause(1);
            	
            };
            
            if(perks[i]==12) {
            	
            	functions.click("//input[@id='job_perks_commuting_stipend']");
                functions.pause(1);
            	
            };
            
            if(perks[i]==13) {
            	
            	functions.click("//input[@id='job_perks_company_retreats']");
                functions.pause(1);
            	
            };
            
            if(perks[i]==14) {
            	
            	functions.click("//input[@id='job_perks_computer_repairs']");                  
                functions.pause(1);
            	
            };
            
            if(perks[i]==15) {
            	
            	functions.click("//input[@id='job_perks_dental_insurance']");                  
                functions.pause(1);
            	
            };
            
            if(perks[i]==16) {
            	
            	functions.click("//input[@id='job_perks_education_stipend']");              
                functions.pause(1);
            	
            };
            
            if(perks[i]==17) {
            	
            	functions.click("//input[@id='job_perks_equity_offered']");
                functions.pause(1);
            	
            };
            
            if(perks[i]==18) {
            	
            	functions.click("//input[@id='job_perks_fitness_subsidies']");
                functions.pause(1);
            	
            };
            
            if(perks[i]==19) {
            	
            	functions.click("//input[@id='job_perks_free_car_parking']");
                functions.pause(1);
            	
            };
            
            if(perks[i]==20) {
            	
            	functions.click("//input[@id='job_perks_life_insurance']");
                functions.pause(1);
            	
            };
            
            if(perks[i]==21) {
            	
            	functions.click("//input[@id='job_perks_meals_provided']");
                functions.pause(1);
            	
            };
            
            if(perks[i]==22) {
            	
            	functions.click("//input[@id='job_perks_mobile_provided']");
                functions.pause(1);
            	
            };
            
            if(perks[i]==23) {
            	
            	functions.click("//input[@id='job_perks_paid_sick_days']");
                functions.pause(1);
            	
            };
            
            if(perks[i]==24) {
            	
            	functions.click("//input[@id='job_perks_parental_leave_over_legal']");
                functions.pause(1);
            	
            };
            
            if(perks[i]==25) {
            	
            	functions.click("//input[@id='job_perks_performance_bonus']");
                functions.pause(1);

            	
            };
            
            if(perks[i]==26) {
            	
            	functions.click("//input[@id='job_perks_retirement_plan']");
                functions.pause(1);
              
            };
            
            if(perks[i]==27) {
            	
            	functions.click("//input[@id='job_perks_shopping_discounts']");
                functions.pause(1);
                
            };
            
            if(perks[i]==28) {
            	
            	functions.click("//input[@id='job_perks_vacation_on_birthday']");
                functions.pause(1);
                
            };
            
            if(perks[i]==29) {
            	
            	functions.click("//input[@id='job_perks_wellness']");
                functions.pause(1);
            	
            };
            
        }; //Fin for perks
        
        
        //Aceptar termino y condiciones
        functions.click("//input[@id='accept_conditions']");
        
        //Localidad
        if(jornada!="3") {
        	
        	functions.fill_input_location_gob("//input[@class='chosen-search-input']", "Santiago (Chile)");
            functions.key_return("//input[@class='chosen-search-input']");
            
        };
            
       //Continuar
        System.out.println("Continuar");
        functions.click("//input[@name='commit']");
        functions.pause(5);
        
        //FALTAN LAS PREGUNTAS ADICIONALES
        System.out.println("Faltan las preguntas adicionales");
        
        //Elementos Extras a incluir
        boolean linkedin = true;	
        boolean git = true;
        boolean portafolio = true; 
        boolean CV = true;
							
        if(linkedin) {
        	
        	functions.click("//input[@id='job_linkedin_required']");
        	functions.pause(1);
        };
        
        if(git) {
        	
        	functions.click("//input[@id='job_github_required']");
        	functions.pause(1);
        };
        
        if(portafolio) {
        	
        	functions.click("//input[@id='job_portfolio_required']");
        	functions.pause(1);
        };
        
        if(CV) {
        	
        	functions.click("//input[@id='job_cv_required']");
        	functions.pause(1);
        };
        
        
      //Continuar al final
      functions.click("//input[@id='continue-to-step3']");
      functions.click("//a[@class='gb-btn size1']");
      
	};
	

	
	
	
}
