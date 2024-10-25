package src;

import java.util.ArrayList;
import java.util.List;

public class MonthReturns {

    // Class to create a relationship between month and return values
    
    private String month; // Month
    private List<Double> returnList = new ArrayList<>(); // Return List

    public MonthReturns() {}

    public MonthReturns(String month) {
        this.month = month;
    }

    public List<Double> getReturnList() {

        return this.returnList;
    }

    public String getMonth() {

        return this.month;
    }

    public void setReturn(Double returnValue) {

        this.returnList.add(returnValue);
    }


    public Double calculateMonthReturn() {

        double sum = 0.0;
        for (Double value : this.returnList) {
            sum += value;
        }

        return sum;
    }
}
