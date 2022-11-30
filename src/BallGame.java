import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Random;
import java.applet.*;
import java.net.*;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JApplet;


@SuppressWarnings("serial")
public class BallGame extends JApplet implements Runnable, MouseMotionListener,MouseListener,KeyListener{
	Random generator=new Random();
	double xpos,ypos;//circle coordinates
	double xcen,ycen;//mouse position
	double xsqu,ysqu;//square coordinates
	double xcircle, yplus,yminus, addvalue;//values for checking circle boundaries
	double vplus, vmax=25, vmin=10;//speed up ball after all are spawned
	double counter=0;
	double attraction=0.01;
	double drag=0.01;
	int plaay=1;
	double [][]randomcircles=new double[8][25];
	boolean GameRunning=true,PlayAgain=true;
	double saver=0;
	int r1=generator.nextInt(850), r2=generator.nextInt(650);
	int s1=generator.nextInt(850), s2=generator.nextInt(650);
	int t1=generator.nextInt(850), t2=generator.nextInt(650);
	int u1=generator.nextInt(850), u2=generator.nextInt(650);
	int v1=generator.nextInt(850), v2=generator.nextInt(650);
	int w1=generator.nextInt(850), w2=generator.nextInt(650);
	int x1=generator.nextInt(850), x2=generator.nextInt(650);
	int y1=generator.nextInt(850), y2=generator.nextInt(650);
	int z1=generator.nextInt(850), z2=generator.nextInt(650);
	

	boolean music=false;
	
	public int rando;
	
	public int scoore=0;
	
	/*
	 * 0=x-position
	 * 1=y-position
	 * 2=diameter
	 * 3=x-velocity
	 * 4=y-velocity
	 * 5=radius
	 * 6=x-center
	 * 7=y-center
	 */ 
	boolean touched=false;//is true when mouse not touching square
	boolean circles=false;//true when circles are generated
	int width,height;
	int score=0;
	double savedscore=0;
	Image offscreenImage;
	
	
	
	Clip clip;
	String location = "File:/Network/Servers/student10.eccrsd.us/Homes/zacharyzaleski/Documents/workspace/skelly/src/dvell.wav";
	
	int XX;
	int XY;
	Image Wilmer;
	Image Sentinel;
	Image GarroshBKG;
	Image ShaBKG;
	Image Garrosh;
	Image Gorehowl;
	Image ShaMobsBKG;
	Image ShaMob;
	Image ShaShot;
	boolean left=false;
	boolean right=false;
	boolean shoot=false;
	int shotX, shotY;
	int shotDelay=0;
	boolean ShotDelay1=true, ShotDelay2=true, ShotDelay3=true, ShotDelay4=true, ShotDelay5=true;
	boolean fire1=false, fire2=false, fire3=false, fire4=false, fire5=false;
	boolean enemy1=true, enemy2=true, enemy3=true, enemy4=true, enemy5=true;
	int enemy1HP=1, enemy2HP=1, enemy3HP=1, enemy4HP=1, enemy5HP=1;
	int userHP=5;
	int start1=0, start2=0, start3=0, start4=0, start5=0;
	int e1x, e2x, e3x, e4x, e5x;
	int e1y, e2y, e3y, e4y, e5y;
	boolean enL=false;
	
	
	int GarroshHP=25;
	boolean Garrosh1=false;
	boolean GarroshL=true;
	boolean GarroshShotDelay=true;
	boolean GarroshFire=false;
	int GStart=0;
	int GX, GY;
	
	
	int ShaMob1HP=10, ShaMob2HP=10, ShaMob3HP=10;
	boolean ShaMobStartup=true;
	boolean ShaMob1=false, ShaMob2=false, ShaMob3=false;
	boolean ShaMob1ShotDelay=true, ShaMob2ShotDelay=true, ShaMob3ShotDelay=true;
	boolean ShaMob1Fire=false, ShaMob2Fire=false, ShaMob3Fire=false;
	int ShaMob1Start=0, ShaMob2Start=0, ShaMob3Start=0;
	int SM1X, SM2X, SM3X;
	int SM1Y, SM2Y, SM3Y;
	
	
	
	Image FinalBKG;
	int BossFight=0;
	boolean START=false;
//** SPM	4
	boolean ShaFinalStartUp=true;
	Image ShaOfViolence;
	int violenceHP=50;
	boolean violenceL=true, violence1=false, violenceShotDelay=true, violenceFire=false;
	int violenceStart=0, violenceX, violenceY;
// townlong 2
	Image ShaOfHatred;
	int hatredHP=40;
	boolean hatredL=true, hatred1=false, hatredShotDelay=true, hatredFire=false;
	int hatredStart=0, hatredX, hatredY;
// jade serpent  3
	Image ShaOfDoubt;
	int doubtHP=45;
	boolean doubtL=true, doubt1=false, doubtShotDelay=true, doubtFire=false;
	int doubtStart=0, doubtX, doubtY;
// kasarand wilds 1
	Image ShaOfDespair;
	int despairHP=35;
	boolean despairL=true, despair1=false, despairShotDelay=true, despairFire=false;
	int despairStart=0, despairX, despairY;
// ToES  6
	Image ShaOfFear;
	int fearHP=75;
	boolean fearL=true, fear1=false, fearShotDelay=true, fearFire=false;
	int fearStart=0, fearX, fearY;
// Kun'Lai  5
	Image ShaOfAnger;
	int angerHP=65;
	boolean angerL=true, anger1=false, angerShotDelay=true, angerFire=false;
	int angerStart=0, angerX, angerY;
// GarroshPride
	Image GarroshPride;
	int garroshPrideHP=150;
	boolean GPL=true, GP1=false, GPShotDelay=true, GPFire=false;
	
	public int end=1100;
	public int stert=0;
	Image Horde;
	Image Self;
	Graphics offscr;
	Random r;
	Thread t;
	Image korkron;
	BallGameMathMethods d;
	boolean inBounds=true;
	boolean onScreen=true;
	boolean playNormal=false, playSeeker=false;
	int s1dirs=-2,s2dirs=2,r1dirs=2,r2dirs=-2, z1dirs=-2, z2dirs=2, y1dirs=2, y2dirs=-2,x1dirs=-2,x2dirs=2,t1dirs=2,t2dirs=-2,v1dirs=-2,v2dirs=2,u1dirs=2,u2dirs=-2,w1dirs=-2,w2dirs=2;
	int copo=1;
	Image Title;
	boolean hasStarted=false;

	public BallGame()
	{
		r=new Random();
		t=new Thread(this);
		d=new BallGameMathMethods();
		t.start();
	}
	public void init()
	{
//		GarroshL=false;
//		enemy1=false; 
//		enemy2=false; 
//		enemy3=false;
//		enemy4=false;
//		enemy5=false;
//		ShaMob1=false;
//		ShaMob2=false;
//		ShaMob3=false;
		XX=700;
		XY=0;
		saver=0;
		addKeyListener(this);
		addMouseMotionListener(this);
		addMouseListener(this);
		setVisible(true);
		setSize(2000, 1500);
		width = getSize().width;
		height = getSize().height;
		Title=getImage(getCodeBase(), "titlescreen.png");
		korkron=getImage(getCodeBase(), "HunterArrow.png");
		Horde = getImage(getCodeBase(), "url.jpeg");
		Self = getImage(getCodeBase(), "hSymbol.png");
		offscreenImage = createImage(width, height);
		offscr = offscreenImage.getGraphics();
		Wilmer = getImage(getCodeBase(), "Wilmer.png");
		Sentinel = getImage(getCodeBase(), "Kor'kron_Vanguard.png");
		GarroshBKG = getImage(getCodeBase(), "GarroshBKG.png");
		ShaBKG = getImage(getCodeBase(), "ShaBKG.png");
		Garrosh = getImage(getCodeBase(), "GarroshPride.png");
		Gorehowl = getImage(getCodeBase(), "GoreHowl.png");
		ShaMobsBKG = getImage(getCodeBase(), "ShaMobsBKG.png");
		ShaMob = getImage(getCodeBase(), "ShaShooter.png");
		ShaShot = getImage(getCodeBase(), "ShaShot.png");
		FinalBKG = getImage(getCodeBase(), "expSCR.png");
		ShaOfViolence = getImage(getCodeBase(), "ShaOfViolence.png");
		ShaOfHatred = getImage(getCodeBase(), "ShaOfHatred.png");
		ShaOfDoubt = getImage(getCodeBase(), "ShaOfDoubt.png");
		ShaOfDespair = getImage(getCodeBase(), "ShaOfDespair.png");
		ShaOfFear =  getImage(getCodeBase(), "ShaOfFearB6.png");
		ShaOfAnger = getImage(getCodeBase(), "ShaOfAnger.png");
		GarroshPride = getImage(getCodeBase(), "GarroshFinalBoss.png");
		
	}
	
	public void paint(Graphics g)
	{
		DecimalFormat df=new DecimalFormat("0.00");
		Random generator=new Random();
		if(copo==1)
		{
			this.playSound(location);
			copo++;
		}
		if (hasStarted)
		{
			if (inBounds)
			{
				super.paint(g);
				BossFight++;
				while(BossFight>=2000)
				{
					START=true;
					rando=generator.nextInt(6)+1;
					BossFight=3000;
					if(rando==1 && hatredL==true)
					{
						FinalBKG = getImage(getCodeBase(), "ShaOfHatredBKG.png");
						BossFight=0;
					}
					if(rando==2 && angerL==true)
					{
						FinalBKG = getImage(getCodeBase(), "ShaOfAngerBKG.png");
						BossFight=0;
					}
					if(rando==3 && fearL==true)
					{
						FinalBKG = getImage(getCodeBase(), "ShaOfFearBKG.png");
						BossFight=0;
					}
					if(rando==4 && violenceL==true)
					{
						FinalBKG = getImage(getCodeBase(), "ShaOfViolenceBKG.png");
						BossFight=0;
					}
					if(rando==5 && doubtL==true)
					{
						FinalBKG = getImage(getCodeBase(), "ShaOfDoubtBKG.png");
						BossFight=0;
					}
					if(rando==6 && despairL==true)
					{
						FinalBKG = getImage(getCodeBase(), "ShaOfDespairBKG.png");
						BossFight=0;
					}
				}
				if(enemy1==true || enemy2==true || enemy3==true || enemy4==true || enemy5==true)
					g.drawImage(GarroshBKG, 0, 0, this);
				if(enemy1==false && enemy2==false && enemy3==false && enemy4==false && enemy5==false && GarroshL==true)
					g.drawImage(ShaBKG, 0, 0, this);
				if(enemy1==false && enemy2==false && enemy3==false && enemy4==false && enemy5==false && GarroshL==false)
					g.drawImage(ShaMobsBKG, 0, 0, this);
				if(enemy1==false && enemy2==false && enemy3==false && enemy4==false && enemy5==false && GarroshL==false && ShaMob1==false && ShaMob2==false && ShaMob3==false)
						g.drawImage(FinalBKG, 0, 0, this);
				int rander=1;
				if(violenceShotDelay==true && violence1==true && violenceL==true)
				{
					rander=generator.nextInt(700)+1;
					if(rander>=698)
					{
						violenceFire=true;
						violenceShotDelay=false;
					}
				}
				if(hatredShotDelay==true && hatred1==true && hatredL==true)
				{
					rander=generator.nextInt(700)+1;
					if(rander>=698)
					{
						hatredFire=true;
						hatredShotDelay=false;
					}
				}
				if(angerShotDelay==true && anger1==true && angerL==true)
				{
					rander=generator.nextInt(700)+1;
					if(rander>=698)
					{
						angerFire=true;
						angerShotDelay=false;
					}
				}
				if(fearShotDelay==true && fear1==true && fearL==true)
				{
					rander=generator.nextInt(700)+1;
					if(rander>=698)
					{
						fearFire=true;
						fearShotDelay=false;
					}
				}
				if(doubtShotDelay==true && doubt1==true && doubtL==true)
				{
					rander=generator.nextInt(700)+1;
					if(rander>=698)
					{
						doubtFire=true;
						doubtShotDelay=false;
					}
				}
				if(despairShotDelay==true && despair1==true && despairL==true)
				{
					rander=generator.nextInt(700)+1;
					if(rander>=698)
					{
						despairFire=true;
						despairShotDelay=false;
					}
				}
				if(GarroshShotDelay==true)
				{
					rander=generator.nextInt(100)+1;
					if(rander>=90)
					{
						GarroshFire=true; 
						GarroshShotDelay=false;
					}
				}
				if(left==true && XX+20>0)
					{
						XX=XX-10;
//						left=false;
					}
				if(right==true && XX-20<1600)
				{
					XX=XX+10;
//					right=false;
				}
				if(shoot==true)
				{
					if(shotDelay==0)
					{
						shotX=XX;
						shotY=650;
						scoore--;
						System.out.println(scoore);
					}
					g.drawImage(korkron, shotX, shotY, this);
					shotY=shotY-10;
					shotDelay++;
					if(shotY==-50)
					{
						shoot=false;
						shotDelay=0;
					}
				}
				if(ShaMob1ShotDelay==true && ShaMob1==true)
				{
					rander=generator.nextInt(100)+1;
					if(rander==100)
					{
						ShaMob1Fire=true;
						ShaMob1ShotDelay=false;
					}
				}
				if(ShaMob2ShotDelay==true && ShaMob2==true)
				{
					rander=generator.nextInt(100)+1;
					if(rander==100)
					{
						ShaMob2Fire=true;
						ShaMob2ShotDelay=false;
					}
				}
				if(ShaMob3ShotDelay==true && ShaMob3==true)
				{
					rander=generator.nextInt(100)+1;
					if(rander==100)
					{
						ShaMob3Fire=true;
						ShaMob3ShotDelay=false;
					}
				}
				if(ShotDelay1==true && enemy1==true)
				{
					rander=generator.nextInt(100)+1;
					if(rander==100)
					{
						fire1=true; 
						ShotDelay1=false;
					}
						
				}
				if(ShotDelay2==true && enemy2==true)
				{
					rander=generator.nextInt(100)+1;
					if(rander>=95)
					{
						fire2=true; 
						ShotDelay2=false;
					}
						
				}
				if(ShotDelay3==true && enemy3==true)
				{
					rander=generator.nextInt(100)+1;
					if(rander>=95)
					{
						fire3=true; 
						ShotDelay3=false;
					}
						
				}
				if(ShotDelay4==true && enemy4==true)
				{
					rander=generator.nextInt(100)+1;
					if(rander>95)
					{
						fire4=true; 
						ShotDelay4=false;
					}
						
				}
				if(ShotDelay5==true && enemy5==true)
				{
					rander=generator.nextInt(100)+1;
					if(rander>=95)
					{
						fire5=true; 
						ShotDelay5=false;
					}
						
				}
				if(shotX>=(XY) && shotX<=(XY+100) && (shotY>=0) && shotY<=200 && shoot==true && ShaMob1==true)
				{
					shoot=false;
					shotDelay=0;
					ShaMob1HP--;
					System.out.println("ShaMob1 hit "+ShaMob1HP+" left");
					scoore=scoore+5;
				}
				if(shotX>=(XY+200) && shotX<=(XY+300) && (shotY>=0) && shotY<=200 && shoot==true && ShaMob2==true)
				{
					shoot=false;
					shotDelay=0;
					ShaMob2HP--;
					System.out.println("ShaMob2 hit "+ShaMob2HP+" left");
					scoore=scoore+5;
				}
				if(shotX>=(XY+400) && shotX<=(XY+500) && (shotY>=0) && shotY<=200 && shoot==true && ShaMob3==true)
				{
					shoot=false;
					shotDelay=0;
					ShaMob3HP--;
					System.out.println("ShaMob3 hit "+ShaMob3HP+" left");
					scoore=scoore+5;
				}
				if(shotX>=(SM1X-30) && shotX<=(SM1X+30) && (shotY<=SM1Y+100) && shotY>=(SM1Y) && shoot==true && ShaMob1Fire==true)
				{
					shoot=false;
					SM1X=0;
					SM1Y=0;
					ShaMob1Fire=false;
					shotDelay=0;
					ShaMob1ShotDelay=true;
					ShaMob1Start=0;
					scoore=scoore+2;
				}
				if(shotX>=(SM2X-30) && shotX<=(SM2X+30) && (shotY<=SM2Y+100) && shotY>=(SM2Y) && shoot==true && ShaMob2Fire==true)
				{
					shoot=false;
					SM2X=0;
					SM2Y=0;
					ShaMob2Fire=false;
					shotDelay=0;
					ShaMob2ShotDelay=true;
					ShaMob2Start=0;
					scoore=scoore+2;
				}
				if(shotX>=(SM3X-30) && shotX<=(SM3X+30) && (shotY<=SM3Y+100) && shotY>=(SM3Y) && shoot==true && ShaMob3Fire==true)
				{
					shoot=false;
					SM3X=0;
					SM3Y=0;
					ShaMob3Fire=false;
					shotDelay=0;
					ShaMob3ShotDelay=true;
					ShaMob3Start=0;
					scoore=scoore+2;
				}
				//6-sha shot collisions
				if(shotX>=(violenceX-30) && shotX<=(violenceX+30) && shotY>=violenceY && shotY<=violenceY+100 && shoot==true && violenceFire==true && violence1==true)
				{
					if(rando==4)
					{
						violenceHP--;
						System.out.println(violenceHP+" violence hit");
					}
					shoot=false;
					violenceX=0;
					violenceY=0;
					violenceFire=false;
					violenceShotDelay=true;
					violenceStart=0;
					shotDelay=0;
					scoore++;
				}
				if(shotX>=(despairX-30) && shotX<=(despairX+30) && shotY>=despairY && shotY<=despairY+100 && shoot==true && despairFire==true && despair1==true)
				{
					if(rando==6)
					{
						despairHP--;
						System.out.println(despairHP+" despair hit");
					}
					shoot=false;
					despairX=0;
					despairY=0;
					despairFire=false;
					despairShotDelay=true;
					despairStart=0;
					shotDelay=0;
					scoore++;
				}
				if(shotX>=(doubtX-30) && shotX<=(doubtX+30) && shotY>=doubtY && shotY<=doubtY+100 && shoot==true && doubtFire==true && doubt1==true)
				{
					if(rando==5)
					{
						doubtHP--;
						System.out.println(doubtHP+" doubt hit");
					}
						
					shoot=false;
					doubtX=0;
					doubtY=0;
					doubtFire=false;
					doubtShotDelay=true;
					doubtStart=0;
					shotDelay=0;
					scoore++;
				}
				if(shotX>=(hatredX-30) && shotX<=(hatredX+30) && shotY>=hatredY && shotY<=hatredY+100 && shoot==true && hatredFire==true && hatred1==true)
				{
					if(rando==1)
					{
						hatredHP--;
						System.out.println(hatredHP+" hatred hit");
					}
					shoot=false;
					hatredX=0;
					hatredY=0;
					hatredFire=false;
					hatredShotDelay=true;
					hatredStart=0;
					shotDelay=0;
					scoore++;
				}
				if(shotX>=(angerX-30) && shotX<=(angerX+30) && shotY>=angerY && shotY<=angerY+100 && shoot==true && angerFire==true && anger1==true)
				{
					if(rando==2)
					{
						angerHP--;
						System.out.println(angerHP+" anger hit");
					}
					shoot=false;
					angerX=0;
					angerY=0;
					angerFire=false;
					angerShotDelay=true;
					angerStart=0;
					shotDelay=0;
					scoore++;
				}
				if(shotX>=(fearX-30) && shotX<=(fearX+30) && shotY>=fearY && shotY<=fearY+100 && shoot==true && fearFire==true && fear1==true)
				{
					if(rando==3)
					{
						fearHP--;
						System.out.println(fearHP+" fear hit");
					}
					shoot=false;
					fearX=0;
					fearY=0;
					fearFire=false;
					fearShotDelay=true;
					fearStart=0;
					shotDelay=0;
					scoore++;
				}
				if((shotX>=(XY-20) && shotX<=(XY+20)) && (shotY<=250) && (shotY>=100) && shoot==true && enemy1==true)
				{
					shoot=false;
					enemy1HP--;
					shotDelay=0;
					scoore=scoore+5;
				}
				if((shotX>=(XY+130) && shotX<=(XY+170)) && (shotY<=250) && (shotY>=0) && shoot==true && enemy2==true)
				{
					shoot=false;
					enemy2HP--;
					shotDelay=0;
					scoore=scoore+5;
				}
				if((shotX>=(XY+280) && shotX<=(XY+320)) && (shotY<=250) && (shotY>=100) && shoot==true && enemy3==true)
				{
					shoot=false;
					enemy3HP--;
					shotDelay=0;
					scoore=scoore+5;
				}
				if((shotX>=(XY+430) && shotX<=(XY+470)) && (shotY<=250) && (shotY>=0) && shoot==true && enemy4==true)
				{
					shoot=false;
					enemy4HP--;
					shotDelay=0;
					scoore=scoore+5;
				}
				if((shotX>=(XY+580) && shotX<=(XY+620)) && (shotY<=250) && (shotY>=100) && shoot==true && enemy5==true)
				{
					shoot=false;
					enemy5HP--;
					shotDelay=0;
					scoore=scoore+5;
				}
				if((shotX>=(XY) && shotX<=(XY+200)) && (shotY<=300) && (shotY>=100) && shoot==true && GarroshL==true && enemy1==false && enemy2==false && enemy3==false && enemy4==false && enemy5==false)
				{					
					shoot=false;
					GarroshHP--;
					shotDelay=0;
					System.out.println("Garrosh has been hit "+GarroshHP+" left");
					scoore=scoore+7;
				}
				//harming the 6-sha
				if(shotX>=(XY) && shotX<=(XY+150) && shotY>=0 && shotY<=200 && shoot==true && violenceL==true && violence1==true && rando==4  && enemy1==false && enemy2==false && enemy3==false && enemy4==false && enemy5==false && GarroshL==false && ShaMob1==false && ShaMob2==false && ShaMob3==false && ShaFinalStartUp==false)
				{
					violenceHP=violenceHP-3;
					shoot=false;
					shotDelay=0;
					System.out.println("Sha of Violence crit! "+violenceHP+" HP left");	
					scoore=scoore+10;
				}
				if(shotX>=(XY+175) && shotX<=(XY+325) && shotY>=0 && shotY<=200 && shoot==true && doubtL==true && doubt1==true && rando==5 &&  enemy1==false && enemy2==false && enemy3==false && enemy4==false && enemy5==false && GarroshL==false && ShaMob1==false && ShaMob2==false && ShaMob3==false && ShaFinalStartUp==false)
				{
					doubtHP=doubtHP-3;
					shoot=false;
					shotDelay=0;
					System.out.println("Sha of Doubt crit! "+doubtHP+" HP left");	
					scoore=scoore+10;
				}
				if(shotX>=(XY+350) && shotX<=(XY+550) && shotY>=0 && shotY<=200 && shoot==true && despairL==true && despair1==true && rando==6  && enemy1==false && enemy2==false && enemy3==false && enemy4==false && enemy5==false && GarroshL==false && ShaMob1==false && ShaMob2==false && ShaMob3==false && ShaFinalStartUp==false)
				{
					despairHP=despairHP-3;
					shoot=false;
					shotDelay=0;
					System.out.println("Sha of Despair crit! "+despairHP+" HP left");
					scoore=scoore+10;
				}
				if(shotX>=(XY+575) && shotX<=(XY+725) && shotY>=0 && shotY<=200 && shoot==true && hatredL==true && hatred1==true && rando==1  && enemy1==false && enemy2==false && enemy3==false && enemy4==false && enemy5==false && GarroshL==false && ShaMob1==false && ShaMob2==false && ShaMob3==false && ShaFinalStartUp==false)
				{
					hatredHP=hatredHP-3;
					shoot=false;
					shotDelay=0;
					System.out.println("Sha of Hatred crit! "+hatredHP+" HP left");	
					scoore=scoore+10;
				}
				if(shotX>=(XY+750) && shotX<=(XY+925) && shotY>=0 && shotY<=200 && shoot==true && angerL==true && anger1==true && rando==2 && enemy1==false && enemy2==false && enemy3==false && enemy4==false && enemy5==false && GarroshL==false && ShaMob1==false && ShaMob2==false && ShaMob3==false && ShaFinalStartUp==false)
				{
					angerHP=angerHP-3;
					shoot=false;
					shotDelay=0;
					System.out.println("Sha of Anger crit! "+angerHP+" HP left");	
					scoore=scoore+10;
				}
				if(shotX>=(XY+950) && shotX<=(XY+1125) && shotY>=0 && shotY<=200 && shoot==true && fearL==true && fear1==true && rando==3 && enemy1==false && enemy2==false && enemy3==false && enemy4==false && enemy5==false && GarroshL==false && ShaMob1==false && ShaMob2==false && ShaMob3==false && ShaFinalStartUp==false)
				{
					fearHP=fearHP-3;
					shoot=false;
					shotDelay=0;
					System.out.println("Sha of Fear crit! "+fearHP+" HP left");	
					scoore=scoore+10;
				}
				if((e1x>=(XX) && e1x<=(XX+200)) && ((e1y>=650) && (e1y<=850)) && fire1==true && enemy1==true)
				{
					System.out.println("Hit");
					userHP--;
					fire1=false;
					ShotDelay1=true;
					e1x=0;
				}
				if((e2x>=(XX) && e2x<=(XX+200)) && ((e2y>=650) && (e2y<=850)) && fire2==true && enemy2==true)
				{
					System.out.println("Hit");

					userHP--;
					fire2=false;
					ShotDelay2=true;
					e2x=0;
				}
				if((e3x>=(XX) && e3x<=(XX+200)) && ((e3y>=650) && (e3y<=850)) && fire3==true && enemy3==true)
				{
					System.out.println("Hit");

					userHP--;
					fire3=false;
					ShotDelay3=true;
					e3x=0;
				}
				if((e4x>=(XX) && e4x<=(XX+200)) && ((e4y>=650) && (e4y<=850)) && fire4==true && enemy4==true)
				{
					System.out.println("Hit");
					userHP--;
					fire4=false;
					ShotDelay4=true;
					e4x=0;
				}
				if((e5x>=(XX) && e5x<=(XX+200)) && ((e5y>=650) && (e5y<=850)) && fire5==true && enemy5==true)
				{
					System.out.println("Hit");
					userHP--;
					fire5=false;
					ShotDelay5=true;
					e5x=0;
				}
				if((GX>=(XX) && GX<=(XX+200)) && ((GY>=650) && (GY<=850) && GarroshFire==true))
				{
					userHP--;
					System.out.println("Garrosh Hit "+userHP+" left");
					GarroshFire=false;
					GarroshShotDelay=true;
					GX=-10000;
				}
				if(userHP<=0)
					GameRunning=false;
				if(enemy1HP<=0)
				{
					enemy1=false;
					if(stert==0)
						stert=stert-150;
				}
				if(enemy2HP<=0)
					enemy2=false;
				if(enemy3HP<=0)
					enemy3=false;
				if(enemy4HP<=0)
					enemy4=false;
				if(enemy5HP<=0)
				{
					enemy5=false;
					if(end==1100)
						end=end+150;
				}
				if(GarroshHP<=0)
				{
					GarroshL=false;
				}
				if(ShaMob1HP<=0)
				{
					ShaMob1=false;
				}
				if(ShaMob2HP<=0)
				{
					ShaMob2=false;
				}
				if(ShaMob3HP<=0)
				{
					ShaMob3=false;
				}
				if(ShaMob1Fire==true && ShaMob1==true)
				{
					if(ShaMob1Start==0)
					{
						SM1X=XY;
						SM1Y=0;
					}
					g.drawImage(ShaShot, SM1X, SM1Y, this);
					SM1Y=SM1Y+1;
					ShaMob1Start++;
					if(SM1Y==1000)
					{
						userHP=0;
						ShaMob1Fire=false;
						ShaMob1Start=0;
						ShaMob1ShotDelay=true;
					}
				}
				if(ShaMob2Fire==true && ShaMob2==true)
				{
					if(ShaMob2Start==0)
					{
						SM2X=XY+200;
						SM2Y=0;
					}
					g.drawImage(ShaShot, SM2X, SM2Y, this);
					SM2Y=SM2Y+1;
					ShaMob2Start++;
					if(SM2Y==1000)
					{
						userHP=0;
						ShaMob2Fire=false;
						ShaMob2Start=0;
						ShaMob2ShotDelay=true;
					}
				}
				if(ShaMob3Fire==true && ShaMob3==true)
				{
					if(ShaMob3Start==0)
					{
						SM3X=XY+400;
						SM3Y=0;
					}
					g.drawImage(ShaShot, SM3X, SM3Y, this);
					SM3Y=SM3Y+1;
					ShaMob3Start++;
					if(SM3Y==1000)
					{
						userHP=0;
						ShaMob3Fire=false;
						ShaMob3Start=0;
						ShaMob3ShotDelay=true;
					}
				}
				if(GarroshFire==true && Garrosh1==true && GarroshL==true)
				{
					if(GStart==0)
					{
						GX=XY;
						GY=100;
					}
					g.drawImage(Gorehowl, GX, GY, this);
					GY=GY+20;
					GStart++;
					if(GY==1000)
					{
						GarroshFire=false;
						GStart=0;
						GarroshShotDelay=true;
					}
				}
				if(violenceFire==true)
				{
					if(violenceStart==0)
					{
						violenceX=XY;
						violenceY=200;
					}
					g.drawImage(ShaShot, violenceX, violenceY, this);
					violenceY=violenceY+1;
					violenceStart++;
					if(violenceY==1000)
					{
						violenceFire=false;
						violenceStart=0;
						violenceShotDelay=true;
						userHP--;
						System.out.println(userHP);
						
					}
				}
				if(doubtFire==true)
				{
					if(doubtStart==0)
					{
						doubtX=XY+175;
						doubtY=200;
					}
					g.drawImage(ShaShot, doubtX, doubtY, this);
					doubtY=doubtY+1;
					doubtStart++;
					if(doubtY==1000)
					{
						doubtFire=false;
						doubtStart=0;
						doubtShotDelay=true;
						userHP--;
						System.out.println(userHP);
					}
				}
				if(despairFire==true)
				{
					if(despairStart==0)
					{
						despairX=XY+350;
						despairY=200;
					}
					g.drawImage(ShaShot, despairX, despairY, this);
					despairY=despairY+1;
					despairStart++;
					if(despairY==1000)
					{
						despairFire=false;
						despairStart=0;
						despairShotDelay=true;
						userHP--;
						System.out.println(userHP);
					}
				}
				if(hatredFire==true)
				{
					if(hatredStart==0)
					{
						hatredX=XY+575;
						hatredY=200;
					}
					g.drawImage(ShaShot, hatredX, hatredY, this);
					hatredY=hatredY+1;
					hatredStart++;
					if(hatredY==1000)
					{
						hatredFire=false;
						hatredStart=0;
						hatredShotDelay=true;
						userHP--;
						System.out.println(userHP);
					}
				}
				if(angerFire==true)
				{
					if(angerStart==0)
					{
						angerX=XY+750;
						angerY=200;
					}
					g.drawImage(ShaShot, angerX, angerY, this);
					angerY=angerY+1;
					angerStart++;
					if(angerY==1000)
					{
						angerFire=false;
						angerStart=0;
						angerShotDelay=true;
						userHP--;
						System.out.println(userHP);
					}
				}
				if(fearFire==true)
				{
					if(fearStart==0)
					{
						fearX=XY+950;
						fearY=200;
					}
					g.drawImage(ShaShot, fearX, fearY, this);
					fearY=fearY+1;
					fearStart++;
					if(fearY==1000)
					{
						fearFire=false;
						fearStart=0;
						fearShotDelay=true;
						userHP--;
						System.out.println(userHP);
					}	
				}
				if(fire1==true && enemy1==true)
				{
					if(start1==0)
					{
						e1x=XY;
						e1y=100;
					}
					g.drawImage(korkron, e1x, e1y, this);
					e1y=e1y+10;
					start1++;
					if(e1y==1000)
					{
						fire1=false;
						start1=0;
						ShotDelay1=true;
					}
				}
				if(fire2==true && enemy2==true)
				{
					if(start2==0)
					{
						e2x=XY+150;
						e2y=100;
					}
					g.drawImage(korkron, e2x, e2y, this);
					e2y=e2y+10;
					start1++;
					if(e2y==1000)
					{
						fire2=false;
						start2=0;
						ShotDelay2=true;
					}
				}
				if(fire3==true && enemy3==true)
				{
					if(start3==0)
					{
						e3x=XY+300;
						e3y=100;
					}
					g.drawImage(korkron, e3x, e3y, this);
					e3y=e3y+10;
					start3++;
					if(e3y==1000)
					{
						fire3=false;
						start3=0;
						ShotDelay3=true;
					}
				}
				if(fire4==true && enemy4==true)
				{
					if(start4==0)
					{
						e4x=XY+450;
						e4y=100;
					}
					g.drawImage(korkron, e4x, e4y, this);
					e4y=e4y+10;
					start4++;
					if(e4y==1000)
					{
						fire4=false;
						start4=0;
						ShotDelay4=true;
					}
				}
				if(fire5==true && enemy5==true)
				{
					if(start5==0)
					{
						e5x=XY+600;
						e5y=100;
					}
					g.drawImage(korkron, e5x, e5y, this);
					e5y=e5y+10;
					start5++;
					if(e5y==1000)
					{
						fire5=false;
						start5=0;
						ShotDelay5=true;
					}
				}
				g.drawImage(Wilmer, XX, 650, this);
				if(enemy1==false && enemy2==false && enemy3==false && enemy4==false && enemy5==false && GarroshL==true)
				{
					stert=0;
					if(Garrosh1==false)
						userHP=5;
					Garrosh1=true;
					end=1700;
					g.drawImage(Garrosh, XY, 100, this);
				}
				if(GarroshL==false && enemy1==false && enemy2==false && enemy3==false && enemy4==false && enemy5==false)
				{
					end=1200;
					stert=0;
					if(ShaMobStartup==true)
					{
						ShaMob1=true;
						ShaMob2=true; 
						ShaMob3=true;
					}
					ShaMobStartup=false;
					if(ShaMob1==true)
						g.drawImage(ShaMob, XY, 0, this);
					if(ShaMob2==true)
						g.drawImage(ShaMob, XY+200, 0, this);
					if(ShaMob3==true)
						g.drawImage(ShaMob, XY+400, 0, this);
				}
//				ShaMob1=false;
//				ShaMob2=false;
//				ShaMob3=false;
				if(GarroshL==false && enemy1==false && enemy2==false && enemy3==false && enemy4==false && enemy5==false && ShaMob1==false && ShaMob2==false && ShaMob3==false && START==true)
				{
					if(ShaFinalStartUp==true)
						userHP=10;
					{
						violence1=true;
						hatred1=true;
						despair1=true;
						doubt1=true;
						fear1=true;
						anger1=true;
						ShaFinalStartUp=false;
					}
					if(enL==false)
					XY=XY-4;
					if(enL==true)
						XY=XY+4;
					if(violenceHP<=0)
					{
						violence1=false;
						violenceL=false;
					}
					if(hatredHP<=0)
					{
						hatred1=false;
						hatredL=false;
					}
					if(despairHP<=0)
					{
						despair1=false;
						despairL=false;
					}
					if(doubtHP<=0)
					{
						doubt1=false;
						doubtL=false;
					}
					if(fearHP<=0)
					{
						fear1=false;
						fearL=false;
					}
					if(angerHP<=0)
					{
						anger1=false;
						angerL=false;
					}
					if(violence1==true)
						g.drawImage(ShaOfViolence, XY, 0, this);
					if(hatred1==true)
						g.drawImage(ShaOfHatred, XY+575, 0, this);
					if(despair1==true)
						g.drawImage(ShaOfDespair, XY+350, 0, this);
					if(doubt1==true)
						g.drawImage(ShaOfDoubt, XY+175, 0, this);
					if(fear1==true)
						g.drawImage(ShaOfFear, XY+950, 0, this);
					if(anger1==true)
						g.drawImage(ShaOfAnger, XY+750, 0, this);
				}
				if(enemy1==true)
					g.drawImage(Sentinel, 0+XY, 100, this);
				if(enemy2==true)
					g.drawImage(Sentinel, 150+XY, 0, this);
				if(enemy3==true)
					g.drawImage(Sentinel, 300+XY, 100, this);
				if(enemy4==true)
					g.drawImage(Sentinel, 450+XY, 0, this);	
				if(enemy5==true)
					g.drawImage(Sentinel, 600+XY, 100, this);
				if(XY>=end)
					enL=true;
				if(ShaFinalStartUp==false && XY>=700)
					enL=true;
				if(XY<=stert)
					enL=false;
				if(enL==true)
					XY=XY-15;
				else
					XY=XY+15;
				if(violenceL==false && hatredL==false && doubtL==false && despairL==false && fearL==false && angerL==false)
					GameRunning=false;
				if(GameRunning==false)
				{
					if(violenceL==false && hatredL==false && doubtL==false && despairL==false && fearL==false && angerL==false)
					{
						offscr.setColor(getBackground());
						offscr.fillRect(0, 0, width, height);
						offscr.setColor(Color.BLACK);
						offscr.drawString("Game by: Zackary Zaleski", 5, 350);
						offscr.drawString("If you enjoyed this game, please continue to support Zack Zaleski and all of his endeavors", 5, 400);
						offscr.drawString("Re-run the program to play again", 0, 0);
						offscr.drawString("Game over", 300, 300);
						offscr.drawRect(300, 310, 80, 20);
						offscr.drawString("YOU WIN!!", 303, 323);
						offscr.setColor(Color.BLACK);
//						offscr.drawRect(0, 0, 499, 499);
						g.drawImage(offscreenImage, 0, 0, this);
						if(savedscore==0)
						{
							savedscore=1;
							saver=0;
						}
						this.start();
					}
					else
					{
						offscr.setColor(getBackground());
						offscr.fillRect(0, 0, 2000, 1000);
						offscr.setColor(Color.BLACK);
						offscr.drawString("Game by: Zackary Zaleski", 5, 350);
						offscr.drawString("If you enjoyed this game, please continue to support Zack Zaleski and all of his endeavors", 5, 400);
						offscr.drawString("scoore: "+scoore, 30, 50);
						offscr.drawString("Re-run the program to play again", 30, 100);
						offscr.drawString("Game over", 300, 300);
						offscr.drawRect(300, 310, 80, 20);
						offscr.drawString("YOU SUCK!", 303, 323);
						offscr.setColor(Color.BLACK);
//						offscr.drawRect(0, 0, 499, 499);
						g.drawImage(offscreenImage, 0, 0, this);
						if(savedscore==0)
						{
							savedscore=1;
							saver=0;
						}
						this.start();
					}
					
				}
			}
			else
			{
							offscr.drawString("Out of Bounds", 250, 250);
							g.drawImage(offscreenImage, 0, 0, this);
				GameRunning=false;
				offscr.setColor(getBackground());;
				offscr.fillRect(0, 0, width, height);
//				offscr.setColor(Color.BLACK);
				offscr.setColor(Color.RED);
				offscr.drawString("Game paused!", 300, 285);
				offscr.drawString("Click to continue", 300, 300);
				offscr.drawRect(300, 310, 80, 20);
				offscr.drawString("Play!", 303, 323);
				offscr.setColor(Color.BLACK);
				offscr.drawRect(0, 0, 2000, 1000);
				g.drawImage(offscreenImage, 0, 0, this);
//				g.drawImage(korkron, 0, 0, this);
			}
		}

		else
		{
			// Game has not started yet.
			g.drawImage(Title, 0, 0, this);
			//g.drawString("X: "+xpos, 350, 490);
			//g.drawString("Y: "+ypos, 425, 490);
		}
	}
	public void update(Graphics g)
	{
		paint(g);
	}
	public void run()
	{
		while(PlayAgain==true)
		{
			while(GameRunning==true)
			{
//				SpeedCheck();
//				SpeedCheckMin();
				MouseHit();
				repaint();
				try
				{
					Thread.sleep(2);
				}
				catch (InterruptedException e){};
			}
			if(GameRunning==false)
			{
				xpos=0;ypos=0;
				xcen=0;ycen=0;
				xsqu=0;ysqu=0;
				xcircle=0; yplus=0;yminus=0; addvalue=0;
				vplus=0;
				counter=0;
				for(int x=0;x<8;x++)
				{
					for(int y=0;y<25;y++)
						randomcircles[x][y]=0;
				}
				circles=false;
				touched=false;
			}
		}	
	}
	public void MouseHit()
	{
		for(int x=0;x<counter;x++)
		{
			if(d.CircleCollision(randomcircles[6][x], randomcircles[7][x], randomcircles[5][x],xcen, ycen, 10))
			{
				savedscore=score;
				GameRunning=false;
			}
		}
	}
	public void SpeedCheck()
	{
		for(int x=0;x<counter;x++)
		{
			if(Math.abs(randomcircles[3][x])>vmax)
				randomcircles[3][x]*=.5;
			if(Math.abs(randomcircles[4][x])>vmax)
				randomcircles[4][x]*=.5;
		}
	}
	public void SpeedCheckMin()
	{
		for(int x=0;x<counter;x++)
		{
			if(Math.abs(randomcircles[3][x])<vmin)
				randomcircles[3][x]*=2.5;
			if(Math.abs(randomcircles[4][x])<vmin)
				randomcircles[4][x]*=2.5;
		}
	}
	public int PositiveNegative(double number)
	{
		if(number>=0)
			return 1;
		else
			return -1;
	}
	public boolean PositionCheck(int x)
	{
//		if(d.CircleSpawnCollision(randomcircles[6][x], randomcircles[7][x], randomcircles[5][x], xcen, ycen, 10)==true)
//		{
//			//randomcircles[0][x]+=150;
//			//randomcircles[1][x]+=150;
//			return true;
//		}	
//		return false;
		return true;
	}
	public boolean BallSpawn(int x)
	{
		for( int y=0;y<counter;y++)
		{
			if(d.CircleCollision(randomcircles[6][x], randomcircles[7][x], randomcircles[5][x], randomcircles[6][y], randomcircles[7][y], randomcircles[5][y])==true)
			{
				//randomcircles[0][x]=r.nextInt(200+100);
				//randomcircles[1][x]=r.nextInt(200+100);
				return true;
			}
			return false;
		}
		return false;
	}
	public void mouseDragged(MouseEvent ev) {
		// TODO Auto-generated method stub
		xpos=ev.getX()-10;
		ypos=ev.getY()-10;
		xcen=ev.getX();
		ycen=ev.getY();
		//repaint();
	}
	public void mouseMoved(MouseEvent ev) {
		// TODO Auto-generated method stub
		xpos=ev.getX()-10;
		ypos=ev.getY()-10;
		xcen=ev.getX();
		ycen=ev.getY();

		//repaint();
	}
	public void mouseClicked(MouseEvent ev)
	{
		// TODO Auto-generated method stub
//		dweller.play();
		if (!hasStarted)
		{
			if ((ev.getX() >= 240 && ev.getX() <= 290) && (ev.getY() >= 310 && ev.getY() <= 350))
			{
				playNormal=true;
				savedscore=0;
			}
			else if ((ev.getX() >= 385 && ev.getX() <= 435) && (ev.getY() >= 310 && ev.getY() <= 350))
				playSeeker=true;
			
			hasStarted=true;
		}
		if(GameRunning==false)
		{
			if(ev.getX()>0&&ev.getX()<1000&&ev.getY()>0&&ev.getY()<1000)
			{
				GameRunning=true;
				//System.out.println("clicked");
			}
		}		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) 
	{
		onScreen=true;
		inBounds=true;
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent ev)
	{
		onScreen=false;
		inBounds=false;
		// TODO Auto-generated method stub
		//GameRunning=false;
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
//		dweller.play();
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
//		dweller.play();

	}
	@Override
	public void keyPressed(KeyEvent e)
	{
		int key=e.getKeyCode();
		if(key==e.VK_A)
			left=true;
		if(key==e.VK_D)
			right=true;
		if(key==e.VK_SPACE && shotDelay==0)
			shoot=true;
	}
	@Override
	public void keyReleased(KeyEvent e)
	{
		int key=e.getKeyCode();
		if(key==e.VK_A)
			left=false;
		if(key==e.VK_D)
			right=false;
		if(key==e.VK_SPACE && shotDelay==0)
			shoot=true;
		if(key==e.VK_M)
			this.playSound(location);
	}
	@Override
	public void keyTyped(KeyEvent e) 
	{
		
		
	}
	
	public void playSound(String location)
	{
		try {
			AudioClip clip = Applet.newAudioClip(
			new URL(location));
			clip.play();
			} catch (MalformedURLException murle) {
			System.out.println(murle);
			}
	}
	public void loopSound(String location)
	{
		try {
			AudioClip clip = Applet.newAudioClip(
			new URL(location));
			clip.loop();
			} catch (MalformedURLException murle) {
			System.out.println(murle);
			}
	}
}