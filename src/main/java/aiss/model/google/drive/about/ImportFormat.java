
package aiss.model.google.drive.about;

import java.util.List;

public class ImportFormat {

    private String source;
    private List<String> targets = null;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public List<String> getTargets() {
        return targets;
    }

    public void setTargets(List<String> targets) {
        this.targets = targets;
    }

}
