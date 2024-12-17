package hu.cubix.zoltan_sipeki.student.exception;

public class EntityNotFoundException extends Exception {
    public EntityNotFoundException(String entity, int id) {
        super(entity + " with id " + id + " does not exist.");
    }
}
