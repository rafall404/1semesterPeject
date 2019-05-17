package semesterProject;

public class Player {
private String name;
private int number;
private char position;
private boolean isInjured;
private boolean isSuspended;

public Player(String name, int number, char position, boolean isInjured, boolean isSuspended) {
	this.name=name;
	this.number=number;
	this.position=position;
	this.isInjured=isInjured;
	this.isSuspended=isSuspended;
}

public Player(String name, int number, char position) {
	this.name=name;
	this.number=number;
	this.position=position;
	this.isInjured=false;
	this.isSuspended=false;
}

public void setName(String name) {
	this.name=name;
}

public String getName() {
	return name;
}

public void setNumber(int number) {
	this.number=number;
}

public int getNumber() {
	return number;
}

public void setPosition(char position) {
	this.position=position;
}

public char getPosition() {
	return position;
}

public void setIsInjured(boolean isInjured) {
	this.isInjured=isInjured;
}

public boolean getIsInjured() {
	return isInjured;
}

public void setIsSuspended(boolean isSuspended) {
	this.isSuspended=isSuspended;
}

public boolean getIsSuspended() {
	return isSuspended;
}

public String toString() {
	return name+", "+number+", "+position+", "+isInjured+", "+isSuspended;
}

public boolean  equals(Object obj) {
	if(!(obj instanceof Player)) {
		return false;
	}
	
	Player other = (Player) obj;
	
	return (other.name.equals(name) && other.number==number && other.position==position && other.isInjured==isInjured && other.isSuspended==isSuspended  );
}



}
