package homecad.model;

//-----------------------------------------------
//s3294287 Tim Hayward assignment 1b
//HomeCAD
//-----------------------------------------------
//Owner implementation
//-----------------------------------------------

public class Owner {
   private String Name;
   private int Budget;
   private int TotalBudget;
   
   public Owner (String name, int budget) {
      Name = name;
      Budget = budget;
      TotalBudget = budget;
   }
   
   public boolean assertSufficientBudget(int cost) {
      if (Budget > cost) return true;
      return false;
   }

   public void decreaseBudget(int cost) {
      Budget = Budget - cost;
   }
   
   public int getAvailableBudget() {
      return Budget;
   }
   
   public String getName() {
      return Name;
   }
   
   public int getTotalBudget() {
      return TotalBudget;
   }
   
   public void increaseBudget (int cost) {
      Budget = Budget + cost;
   }
   
   public void resetBudget () {
      Budget = TotalBudget;
   }
   
   public String toString () {
      //format: <name>:<initial_budget>:<available_budget>
      return Name + ":" + TotalBudget + ":" + Budget;
   }
   
}
