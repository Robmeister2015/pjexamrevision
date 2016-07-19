import java.util.*;

public enum moduleDao {

	instance;

	private Map<String, Module> moduleMap = new HashMap<String, Module>();

	private moduleDao() {

		Module module1 = new Module();
		module1.setLecturer("Seán Kennedy");
		module1.setModuleName("Object Oriented Programming II");
		module1.setModuleCode("101");
		moduleMap.put("101", module1);

		Module module2 = new Module();
		module2.setLecturer("Paul Jacob");
		module2.setModuleCode("102");
		module2.setModuleName("Distributed Systems & Security");
		moduleMap.put("102", module2);

	}

	public List<Module> getAllModules() {

		List<Module> moduleList = new ArrayList<Module>();

		moduleList.addAll(moduleMap.values());

		return moduleList;

	}

	public Module getModule(String moduleCode) {
		return moduleMap.get(moduleCode);
	}

	public void create(Module module) {
		moduleMap.put(module.getModuleCode(), module);
	}

	public void delete(String id) {
		if (moduleMap.remove(id) != null) {
			System.out.println("Removed");
		} else {
			System.out.println("Not Removed");
		}
	}
}
