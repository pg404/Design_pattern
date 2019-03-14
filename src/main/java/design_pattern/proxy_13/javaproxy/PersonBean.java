package design_pattern.proxy_13.javaproxy;

public interface PersonBean {
 
	String getName();
	String getGender();
	String getInterests();
	int getHotOrNotRating();
 
    void setName(String name);
    void setGender(String gender);
    void setInterests(String interests);
    void setHotOrNotRating(int rating); 
 
}
