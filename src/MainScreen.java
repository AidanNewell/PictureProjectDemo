
public class MainScreen extends FlexiblePictureExplorer{

	private String path = "slideshow/";
	//This is used so I don't have to type it out every time in the three dimensional array
	
	
	private String[][][] images = new String[][][] {{{},{},{}},
										 	 	   {{},{},{}},
										 	 	   {{},{},{}}};
	
	
	
	public MainScreen() {
		super(null);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mouseClickedAction(DigitalPicture pict, Pixel pix) {
		// TODO Auto-generated method stub
		
	}
	
}
