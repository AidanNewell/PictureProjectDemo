import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextLayout;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;


public class MainScreen extends FlexiblePictureExplorer implements ImageObserver{

	private String path = "slideshow/";
	//This is used so I don't have to type it out every time in the three dimensional array
	
	//Each slideshow of photos is on a different line
	private final String[][][] images = new String[][][] {{{path+"children.jpg",FINDTHIS,path+"Nassau Hall.jpg",path+"Amtrak.jpg",path+"Plane.jpg",path+"Jane.jpg",path+"TravelCollage.jpg",path+"Cat.jpg",path+"watermelon-touramline.jpg",path+"Littlebrook.PNG",path+"Princeton-Day-School.PNG",path+"Bucks-Rock.jpg",path+"graduation.jpg"},
													       {path+"school.jpg",path+"Brown.jpg",path+"formula.jpg",path+"IBM.jpg",path+"StonyBrook.jpg",path+"Generic-Diploma.jpg",path+"Temp-ui.jpg"},
												       	   {path+"maryland-road-map.gif",path+"STSI.jpg",path+"hubble.jpg",path+"JHU.jpg",path+"Schedule.jpg",FINDTHIS,path+"auditorium.jpg"}},
										 	 	          {{FINDTHIS,FINDTHIS,path+"timonium.png",path+"Matt.jpg",path+"Rachel.jpg",path+"Ellicott.PNG",path+"Guinea Pigs.jpg",path+"centennial.png",path+"Columbia.PNG"},
												      	   {},
													       {path+"Gender-Symbol.jpg",path+"Trans-Pride.jpg",path+"boy-and-girl-playing.jpg",path+"Gender-Dysphoria",path+"brain.jpg",path+"Transition.jpg",FINDTHIS,path+"Discrimination.png",COLLAGE}},
										 	  	          {{path+"clipart-earth.png",path+"earth.jpg",path+"GSA.jpg",path+"OWL.jpg",path+"Trans-Lifeline.png",FINDTHIS,path+"PFLAG-Picture.PNG",path+"pastoral-care.jpg"},
													       {path+"Chalice.jpg",FINDTHIS,path+"UUA.jpg",FINDTHIS,path+"Seven-UU-Principles.jpg",path+"Religion-Collage.png",path+"UUCC-Logo.PNG"},
													       {path+"Boardgame.gif"}}};
	
	
	
	Picture[] Tests;
	private int row;
	private int col;
	private int depth;
	private boolean main;
	public MainScreen(){
		super(new Picture(700,600));
		displayMain();
		row = 0; 
		col = 0;
		depth = 0;
	}
	private void displayMain() {
		main = true;
		Picture disp = new Picture(600, 600);
		Graphics2D graphics = disp.createGraphics();
		int counter = 0;
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				Picture pict;
				pict = new Picture(images[x][y][0]);
				graphics.drawImage(pict.getBufferedImage(), 200*x, 200*y, this);
				counter++;
			}
		}

		setImage(disp);
		// setImage() changes the title each time it's called
		setTitle("All About Me");
	}
	private void displayPhoto(int row, int col, int depth){
		main = false;
		Picture disp = new Picture(700,600);
		Graphics2D graphics = disp.createGraphics();
		System.out.println("row:" + row + " col:" + col + " depth:" + depth);
		//Picture photo = new Picture(images[row][col][depth]);
		Picture photo = new Picture("images\\arch.jpg");
		int x = (600 - photo.getWidth())/2;
		int y = (540 - photo.getHeight())/2;
		graphics.drawImage(photo.getBufferedImage(), x, y, this);

		AttributedString caption = new AttributedString("Famous transgender people include Hollywood directors "
				+ "Lily and Lana Wachowski, computer designer Lynn Conway, jazz "
				+ "musician Billy Tipton, and Olympic athlete Caitlyn Jenner.");
		graphics.setColor(Color.white);
		//graphics.drawString(caption, 20,550);
//		FontMetrics metrics = g.getFontMetrics(font);
//		int length = metrics.stringWidth(s)
		Picture arrows = new Picture("src\\arrows.png");
		graphics.drawImage(arrows.getBufferedImage(),0,600,this);
		setImage(disp);
	}
	public void mouseClickedAction(DigitalPicture pict, Pixel pix) {

		if(main){
			row = (int) pix.getY()/200;
			col = (int) pix.getX()/200;
			depth = 1;
			displayPhoto(row,col,depth);
			System.out.println("R/C" + row + " " + col);
		}
		else if(pix.getY()>600){
			System.out.println(row + " " + col);
			if(pix.getX()/200 == 0 && depth>1){
				System.out.println("decrease");
				depth--;
				displayPhoto(row,col,depth);
			}
			else if(pix.getX()/200 == 1)
				displayMain();
			else if(pix.getX()/200 == 2){
				System.out.println("increase");
				depth++;
				displayPhoto(row,col,depth);
			}
		}
	}
	public boolean imageUpdate(Image arg0, int arg1, int arg2, int arg3,
			int arg4, int arg5) {
		return false;
	}
	public static void main (String args[]){
		new MainScreen();
	}
	
}
