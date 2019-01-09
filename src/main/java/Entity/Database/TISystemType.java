package Entity.Database;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name ="Typ_Systemu")
public class TISystemType {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	@OneToMany(cascade = CascadeType.ALL)
	private List<TISafetyAttribute> safetyAttribute;
	
	

	public TISystemType() {
		super();
	}

	public TISystemType(String name, List<TISafetyAttribute> safetyAttribute) {
		super();
		this.name = name;
		this.safetyAttribute = safetyAttribute;
	}
	

	public TISystemType(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public List<TISafetyAttribute> getSafetyAttribute() {
		return safetyAttribute;
	}

	public void setSafetyAttribute(List<TISafetyAttribute> safetyAttribute) {
		this.safetyAttribute = safetyAttribute;
	}
	
	
	
}
