
package aiss.model.google.drive.about;

import java.util.List;

public class RoleSet {

    private String primaryRole;
    private List<String> additionalRoles = null;

    public String getPrimaryRole() {
        return primaryRole;
    }

    public void setPrimaryRole(String primaryRole) {
        this.primaryRole = primaryRole;
    }

    public List<String> getAdditionalRoles() {
        return additionalRoles;
    }

    public void setAdditionalRoles(List<String> additionalRoles) {
        this.additionalRoles = additionalRoles;
    }

}
