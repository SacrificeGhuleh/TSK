package tsk2020.CV02;

public class PersonController {
    // @Inject would be here <-- Dependency injection
    private PersonDAO personDAO;


    public boolean hasRole(int id, String role) {
        if(id <= 0){
            throw new IllegalArgumentException("ID shall be greater than zero");
        }
        Person p = personDAO.find(id);
        if (p != null) {
            return p.getRole().contains(role);
        }
        return false;
    }
}
