

public class Hooks{


@Before

public static void initDriver(){
	TestBase.initDriver();
}

@After

public void tearDown (Sceanrio scenario){
if (scenario.isFailed()){
	TakeScreenshot screen = (TakeScreenshot) Testbase..getDriver();
	byte[] imgBytes = screen.getScreenShotAs(OutputType.Bytes);
	scenario.attach(imgBytes,"images/png","ScreenImage");
}

}