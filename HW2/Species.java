/*
CSE 17
Zihan Liu
zil317
Homework #2 DEADLINE: September 10, 2016
Program: Endangered Species
*/ 


  /**A class to track the population of various animal species. */
  
  public class Species{
  
  //fields: from the middle of the UML diagram 
  String commonName;
  int population;
  double growthRate;
  int updateYear;

  /**construct a new default species*/
  public Species(){
    commonName = "n/a";
    population = 0;
    growthRate = 0;
    updateYear = 2016;
  }
  
  /**Construct a new Species with given name, pupulation, growth rate and updated year. */
  public Species(String acommonName, int apopulation, double agrowthRate, int aupdateYear){
    commonName = acommonName;
    population = apopulation;
    growthRate = agrowthRate;
    updateYear = aupdateYear;
  }
  /**return if a species is endangered based on its population*/
  public static boolean isEndangered(int number){
    if(number<=5000){
      return true;
    }
    else{
      return false;
    }
  }
  
  /**predict the population of a species for a future year */
  public static int predictPopulation(int futureYear, Species type){
    int newPopulation;
    int updatePopulation=type.population;
    for(int i= type.updateYear; i<=futureYear; i++){
    newPopulation = (int)(updatePopulation*(1+type.growthRate));
    updatePopulation=newPopulation;
    }
    return updatePopulation;
  }
  
  /**print out a population table of estimated population for each year from update year to a specified year*/
  public static void printPopulationTable(int futureYear, Species type){

    System.out.println("YEAR"+"    "+"POPULATION");
    System.out.println("----"+"    "+"----------");
    for(int i=type.updateYear; i<=futureYear; i++){
      System.out.println(i+"    "+predictPopulation(i,type));
    }
  }
   /**print out the information for each species*/
   public static void printSpeciesData(Species[] objects){
      for(int i=0; i < objects.length; i++){
        Species aObject = objects[i];
        System.out.println("Species: "+ aObject.commonName);
        System.out.println("Population: "+ aObject.population);
        System.out.println("Growth Rate: " + String.format("%2.1f%%",aObject.growthRate*100));
        if(isEndangered(aObject.population)==true){
          System.out.println("*** IS ENDANGERED ***");
        }
        System.out.println("Last Update: "+ aObject.updateYear);
        System.out.println("");
      }
   }
 /**create a mian method in the species class*/
 public static void main(String[] args) {
   // create three species objects in an array  
   Species[] mySpecies = {
     new Species("Blue Whale", 2300, 0.082, 2016),
     new Species("Polar Bear", 23000, -0.22, 2016),
     new Species("Cheetah", 11000, -0.05, 2011)
   };
   
   //print out species information
   printSpeciesData(mySpecies);
   
   //predict the population of blue whale in 2025
   System.out.println("The prediction of the blue whale in 2025 is "+predictPopulation(2025, mySpecies[1]));
   
   System.out.println("");
   //output a table of population prediction for cheetahs up to year 2018
   printPopulationTable(2018, mySpecies[2]);
   
 }
  }
   
   

                               
    
                                       
   
    