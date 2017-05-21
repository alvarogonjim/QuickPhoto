
package aiss.model.google.drive.about;

import java.util.List;

public class AdditionalRoleInfo {

    private String type;
    private List<RoleSet> roleSets = null;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<RoleSet> getRoleSets() {
        return roleSets;
    }

    public void setRoleSets(List<RoleSet> roleSets) {
        this.roleSets = roleSets;
    }

}
