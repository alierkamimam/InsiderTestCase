package utilities;

import pages.*;

public class Pages {

	private final HomePage HOME_PAGE;

	private final CareersPage CAREER_PAGE;

	private final QualityAssurancePage QUALITY_ASSURANCE_PAGE;

	private final OpenPositionsPage OPEN_POSITIONS_PAGE;

	private final LeverAppPage LEVER_APP_PAGE;

	public Pages() {
		this.HOME_PAGE = new HomePage();
		this.CAREER_PAGE = new CareersPage();
		this.QUALITY_ASSURANCE_PAGE = new QualityAssurancePage();
		this.OPEN_POSITIONS_PAGE = new OpenPositionsPage();
		this.LEVER_APP_PAGE = new LeverAppPage();
	}

	public HomePage getHOME_PAGE() {
		return HOME_PAGE;
	}

	public CareersPage getCAREER_PAGE() {
		return CAREER_PAGE;
	}

	public QualityAssurancePage getQUALITY_ASSURANCE_PAGE() {
		return QUALITY_ASSURANCE_PAGE;
	}

	public OpenPositionsPage getOPEN_POSITIONS_PAGE() {
		return OPEN_POSITIONS_PAGE;
	}

	public LeverAppPage getLEVER_APP_PAGE() {
		return LEVER_APP_PAGE;
	}

}
