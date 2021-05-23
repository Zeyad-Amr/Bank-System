package bank;



public class Account {

    private String name;
    private String nationalId;
    private String password;
    private String phone;
    private String birthDate;
    
    private Float balance;
    private Float creditBalance;
    private Float status;
    private String creditDate;
    private String creditEndDate;
    
    

        public void setName(String name) {
        this.name = name;
            }
        public String getName() {
        return name;
            }


        public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
            }
        public String getNationalId() {
        return nationalId;
            }


        public void setPassword(String password) {
        this.password = password;
            }
        public String getPassword() {
        return password;
            }

            
        public void setPhone(String phone) {
        this.phone = phone;
            }
        public String getPhone() {
        return phone;
            }


        public void setBirthDate(String birthDate){
        this.birthDate = birthDate;
            }
        public String getBirthDate(){
        return birthDate;
            }
                
        
        public void setBalance(Float balance){
        this. balance = balance ;
            }
        public Float getBalance(){
        return balance;
            }
            
            
        public void setCreditBalance(Float creditBalance){
        this. creditBalance = creditBalance ;
            }
        public Float getCreditBalance(){
        return creditBalance;
            }


        public float status(){
            if (balance<0)
            System.out.println("indebt");
            return balance;
            }


        public void setCreditDate(String creditDate) {
        this.creditDate = creditDate;
            }
        public String getCreditDate() {
        return creditDate;
            }


        public void setCreditEndDate(String creditEndDate) {
        this.creditEndDate = creditEndDate;
            }
        public String getCreditEndDate() {
        return creditEndDate;
            }

        




        
    }
