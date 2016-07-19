import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "module")
public class Module {

	private String moduleCode;
	private String lecturer;
	private String moduleName;
	
	public String getModuleCode(){
		return moduleCode;
	}
	
	public void setModuleCode(String moduleCode){
		this.moduleCode = moduleCode;
	}
	
	public String getLecturer(){
		return lecturer;
	}
	
	public void setLecturer(String lecturer){
		this.lecturer = lecturer;
	}
	
	public String getModuleName(){
		return moduleName;
	}
	
	public void setModuleName(String moduleName){
		this.moduleName = moduleName;
	}
}
