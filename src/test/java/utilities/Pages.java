package utilities;

import pages.CareersPage;
import pages.HomePage;

public class Pages {
    private final HomePage HOME_PAGE;
    private CareersPage CAREER_PAGE;

    public Pages(){
        this.HOME_PAGE =new HomePage();
        this.CAREER_PAGE =new CareersPage();
    }
    public HomePage getHOME_PAGE() {
        return HOME_PAGE;
    }
    public CareersPage getCAREER_PAGE(){
        return CAREER_PAGE;
    }

}
