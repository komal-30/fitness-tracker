public interface UserActions {

    default double calculateBMI(double weight, double height) {
    if (privateMethod(weight,height) == true){
        return weight / (height * height);
    }
    else
        return 0;

    }

    private boolean privateMethod(double weight, double height) {
        if(weight > 0 && height > 0) {
            return true;
        }
        return false;
    }
}
