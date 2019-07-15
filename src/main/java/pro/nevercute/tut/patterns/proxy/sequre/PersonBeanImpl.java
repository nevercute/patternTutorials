package pro.nevercute.tut.patterns.proxy.sequre;

public class PersonBeanImpl implements PersonBean {
    private String name;
    private String gender;
    private String interests;
    private int rating;
    private int ratingCount = 0;

    public PersonBeanImpl(String name, String gender, String interests){
        this.name = name;
        this.gender = gender;
        this.interests = interests;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getGender() {
        return this.gender;
    }

    @Override
    public String getInterests() {
        return this.interests;
    }

    @Override
    public int getHotOrNotRating() {
        if(ratingCount == 0)
            return 0;
        return (rating/ratingCount);
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public void setInterests(String interests) {
        this.interests = interests;
    }

    @Override
    public void setHotOrNotRating(int rating) {
        this.rating += rating;
        ratingCount++;
    }

    public String toString(){
        return "\nPerson: \nName: "+name
                +"\nGender: "+gender
                +"\nInterests: "+interests
                +"\nRatings: "+getHotOrNotRating();
    }
}
