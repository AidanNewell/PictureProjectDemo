
public class MainScreen extends FlexiblePictureExplorer{

	private String path = "slideshow/";
	//This is used so I don't have to type it out every time in the three dimensional array
	
	//Each slideshow of photos is on a different line
	private final String[][][] images = new String[][][] {{{path+"children.jpg",FINDTHIS,path+"Nassau Hall.jpg",path+"Amtrak.jpg",path+"Plane.jpg",path+"Jane.jpg",path+"TravelCollage.jpg",path+"Cat.jpg",path+"watermelon-touramline.jpg",path+"Littlebrook.PNG",path+"Princeton-Day-School.PNG",path+"Bucks-Rock.jpg",path+"graduation.jpg"},
													       {path+"school.jpg",path+"Brown.jpg",path+"formula.jpg",path+"IBM.jpg",path+"StonyBrook.jpg",path+"Generic-Diploma.jpg",path+"Temp-ui.jpg"},
												       	   {path+"maryland-road-map.gif",path+"STSI.jpg",path+"hubble.jpg",path+"JHU.jpg",path+"Schedule.jpg",FINDTHIS,path+"auditorium.jpg"}},
										 	 	          {{FINDTHIS,FINDTHIS,path+"timonium.png",path+"Matt.jpg",path+"Rachel.jpg",path+"Ellicott.PNG",path+"Guinea Pigs.jpg",path+"centennial.png",path+"Columbia.PNG"},
												      	   {},
													       {path+"Gender-Symbol.jpg",path+"Trans-Pride.jpg",path+"boy-and-girl-playing.jpg",path+"Gender-Dysphoria",path+"brain.jpg",path+"Transition.jpg",FINDTHIS,path+"Discrimination.png",COLLAGE}},
										 	  	          {{},
													       {},
													       {}}};
	
	
	
	public MainScreen() {
		super(null);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mouseClickedAction(DigitalPicture pict, Pixel pix) {
		// TODO Auto-generated method stub
		
	}
	
}
