/**/
import sun.audio.AudioStream;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
//WHY THIS IS WORTH CONTUNUING:
//Fact: I currently believe that I find many nested functions easier to understand in condensed, nested form than with useless variable names and steps.
//∴ ⨁ of two cases:
//   ﹣Case １: Other people know something that I don't yet, and I am thinking about this all wrong and in the future my opinion may chane about this.
//   ﹣Case ２: I think about code in ways that not everybody else does, but my way is equally efficient or better in this respect. In this case, it is ridiculous ro assume that I am the only one who benefits from this and ∴ ∃ others will find it useful
//NOTE: THis code assumes that
//   ((x&&y)||(z&&a))
//NOTE: THis code assumes that
//!!!!!!!! NOTE !!!!!!!! all 11 tags:
// TAG:IGNORE()
// TAG:CUSTOM:5:ABCDE  ⟵ The number is contained in one character. If you want more than 9 characters in the custom, you must calculate the correct unicode character number. Have fun :D   (You shouldn't EVER need that though)
// TAG:MATLAB
// TAG:JAVA
// TAG:PYTHON
// TAG:TEXT
//
// TAG:SLOW
//⁠⁠⁠⁠⁠                         ⎧                    ⎫
//⁠⁠⁠⁠⁠                    ⎧  ⎫ ⎪⎧               ⎫   ⎪
// TAG:COPYOUTPUT   (((()) ((()asd()ads()sda)ads)
//⁠⁠⁠⁠⁠                    ⎩  ⎭ ⎪⎩               ⎭   ⎪
//⁠⁠⁠⁠⁠                         ⎩                    ⎭
// TAG:WALUIGI WAA WAA WAA
// TAG:NORMALPASTE
//more advanced options (these, unlike the others, stick around in the memory even when reading new code. Hence why there's the on/off options.):
// SET:SELECTALL:TRUE     ⟵ ﹙Default﹚
// SET:SELECTALL:FALSE
// SET:DESELECT:TRUE
// SET:DESELECT:FALSE     ⟵ ﹙Default﹚  ⟵ In Intellij, at least, this is not a nessecary thing to do because it deselects on paste)
// SET:HIDELEVEL1:TRUE    ⟵ ﹙Default﹚ Is responsible for not outlining the inntermost parenthesis. Is true by default.
// SET:HIDELEVEL1:FALSE   ⟵ If set to false, will show (x(x)x) as 3020203, so that at the 2's it enlarges the parenthesis. Can get annoying on small things.
/**/
/**/
@SuppressWarnings({"W3eakerAccess","Duplicates"})
//REQUITREMENTS: The language must have some sort of line-comment syntax. SML, for example, will not work. It can auto-differentiate between java and python. If you want you can specify custom tags. You can change parenthesis type by erasing 3 times in a row (you'll hear a different sound). Move mouse to top left or top right of screen to actuvate.
class HowtoDetermineWhatLanguageWeʹreReading
{
    public static boolean ParenthesisAesthetical=true;//UserInput++
    public static int
    countSubstrings(final String string,final String substring)
    {
        //Count number of substrings in string
        int count=0;
        int idx=0;
        while((idx=string.indexOf(substring,idx))!=-1)
        {
            idx++;
            count++;
        }
        return count;
    }
    public static String[] ThingsYouWouldUsuallyOnlySeeIn_Python=new String[]{"#","def "," not ",",)",",)","=["};
    public static String[] ThingsYouWouldUsuallyOnlySeeIn_Java=new String[]{";\n","public ","class ","void ","main(String","//","++","++","++"};
    public static String languageGuessToCommentLine(String codeGiven)
    {
        //FIRST PRIORITY: EASTER EGG
        if(codeGiven.contains("TAG:WALUIGI"))
        {
            try
            {
                //GO WAA AT LEAST ONCE
                Audio.waa();
                //MAKE AN ADDITIONAL WAA FOR EACH "TAG:WAA"
                for(int i=0, j=countSubstrings(codeGiven,"WAA");i<j;i++)
                {
                    Audio.waa();
                }
            }
            catch(Exception ignored)
            {
            }
        }
        //SECOND PRIORITY: ACTUALLY DOING STUFF
        final String invisi_trail="\u2060\u2060\u2060";//Completely invisible characters that prevent accidents from happening.
        //And now if we want to specify a custom comment type: TAG:CUSTOM:2://   (2 characters long and is //)
        String custom="TAG:CUSTOM:";
        if(codeGiven.contains(custom))
        {
            try
            {
                System.out.println("\nNEXT 3 LINES ARE FOR CUSTOM STRING:");
                int index=codeGiven.indexOf(custom)+custom.length();//We assume that it's only 1 digit long. Honestly this is a rational assumption.
                System.out.println(index);
                int numberchar=codeGiven.charAt(index)-'0';
                System.out.println(numberchar);
                index++;//Because TAG:CUSTOM:3:  ⟵ the ':' characters between the digit and the comment line
                String output=codeGiven.substring(index+1,index+numberchar+1)+invisi_trail;
                System.out.println(output);
                System.out.println("TAG:CUSTOM SUCCESSFUL\n");
                return output;
            }
            catch(Exception ignored)
            {
                System.out.println("CUSTOM STRING FAILED. WILL TRY TO AUTO-DETECT PYTHON VS JAVA INSTEAD");
            }
        }
        System.out.println("NO CUSTOM COMMENT TYPE SPECIFIED. LOOKING FOR BUILT-IN TAGS INSTEAD.");
        final String python="#"+invisi_trail;
        final String java="//"+invisi_trail;
        final String matlab="%"+invisi_trail;
        final String text=" "+invisi_trail;
        Runnable tag_specified_notification=()->
        {
            System.out.println("\nBUILT-IN LANGUAGE TAG SUCCESSFUL.\nWILL NOT ATTEMPT TO AUTO-DETECT LANGUAGE.\n");
        };
        if(codeGiven.contains("TAG:MATLAB"))
        {
//            tag_specified_notification.run();
            tag_specified_notification.run();
            return matlab;
        }
        if(codeGiven.contains("TAG:JAVA"))
        {
//            tag_specified_notification.run();
            tag_specified_notification.run();
            return java;
        }
        if(codeGiven.contains("TAG:PYTHON"))
        {
//            tag_specified_notification.run();
            tag_specified_notification.run();
            return python;
        }
        if(codeGiven.contains("TAG:TEXT"))
        {
//            tag_specified_notification.run();
            tag_specified_notification.run();
            return text;
        }
        System.out.println("NO BUILT-IN LANGUAGE TAGS SPECIFIED. AUTO-DETECTING LANGUAGE.");
        //NOTE: And...if they didn't specify the language/lack of a language (aka TEXT) then we assume it's either Python or Java and try to detect it automatically.
        int PointsForJava=0;
        for(String x : ThingsYouWouldUsuallyOnlySeeIn_Java)
        {
            PointsForJava+=countSubstrings(codeGiven,x);
        }
        int PointsForPython=0;
        for(String x : ThingsYouWouldUsuallyOnlySeeIn_Python)
        {
            PointsForPython+=countSubstrings(codeGiven,x);
        }
        // we analyze the results…
        if(PointsForJava>PointsForPython)//'points' ∝ certainty
        {
            System.out.println("LANGUAGE AUTO-DETECTED: JAVA\n");
            return java;
        }
        else
        {
            System.out.println("LANGUAGE AUTO-DETECTED: PYTHON\n");
            return python;
        }
    }
}
@SuppressWarnings("Duplicates")
public class MakeParenthesis_Automator extends r
{
    /**
     * ÷
     * //   "I Love My Pony"™ © Thomas Pon²⁰¹⁶
     * //   (y÷√(x²+y²))²⁷^⋂ˣ ·…
     * //   if a ⊆ b ⋀ b ⊆ c, then a ⊆ c
     * //   ㏑(eˣ) = x, ∀ x ∈ ℝ   ·  Ryan Burgert™
     * //   xᵀϴ ∂ϴ÷∂t=(ϴ-(∂J÷∂ϴ)·α) eⁱ³≈1
     * //   fₙ₊₁=fₙ²+1 ⟹ fₙ ≈ 2.4143…^(2ⁿ)
     * //   y ∝ m · x ⟺ y ∝ m ⋀ y ∝ x
     * //   v = f · λ
     * //   ( ℤ ⋂ [1,7] ) = {1,2,3,4,5,6,7}
     * //   ℤ ⊂ ℝ ⟹ ℤ ⊆ ℝ, and also ℤ ≠ ℝ, ∴ ℤ ⊂ ℝ
     * //   a ⊆ b ⋀ a ⊄ b ⟹ a = b
     * //   a ⊈ b ⋀ a ≠ b ⟺ a ⊈ b
     * //   a ⋀ b ⋁ a ⋀ c ☰ a ⋀ (b ⋁ c)
     * //   a ± b = {a+b, a-b}
     * //   fₓ = x² ⟹ f′ₓ = 2·x
     * //   modus ponens: (a ⟹ b) ⋀ a ∴ b
     * //   modus tollens: (a ⟹ b) ⋀ ¬a ∴ ¬b
     * //   ¬(a ⋀ b) ☰ a ⊼ b
     * //   ∂÷∂x ∫f(x)∂x = f(x)
     * //   ∑(∀ x ∈ ℤ ⋂ [1,n]) = ½(x·(x+1)) = ½(x²+x) = ½·x²+½·x
     * //   2≠3
     * //   ∂x ÷ ∂y = lim ∆x ÷ ∆y as ∆ ⟶ 0
     * //   C = 2πr = τr ⋀ A = πr²
     * //   ∏x = exp(∑㏑(x))
     * //   x ∈ {a,b} ⟺ x=a ⋁ x=b
     * //   x² = y ⟺ x ∈ ±√y
     * //   3.14159… = π ≈ 3.14159
     * //   μ(x) = ∑x÷|x|
     * //   x = ⌊x⌋ ☰ x = ⌈x⌉ ☰ 1|x ☰ x ∈ ℤ ☰ x%1 = 0 ☰ ∃ n ∈ ℤ s.t. 1·n = x
     * //   ±λ ϴ
     * //１//endregion
     * 2𝜋
     * ∫
     * 𝑑
     * 𝑎 + 𝑏 sin
     * 2
     * 0
     * = ⋂ ⋂
     * 1
     * √𝑎
     * 2 − 𝑏
     * 2
     * {
     * ////                           ⎧             ⎫
     * /
     **/
    public static void strokeKeys(Robot robot,double delaytime,int... keys)
    {
        for(int k : keys)
        {
            robot.keyPress(k);
        }
        r.delay(delaytime);
        for(int k : keys)
        {
            robot.keyRelease(k);
        }
    }
    public static void rapidlyMashKeys(Robot robot,double totaldelaytime,int numberOfTimesToMashKeys,int... keys)
    {
        double trueDelayTime=totaldelaytime/numberOfTimesToMashKeys;
        for(int ⵁ : new int[numberOfTimesToMashKeys])
        {
            strokeKeys(robot,trueDelayTime,keys);
        }
    }
    public static int counter;
    public static void main(String[] args) throws Exception//into the ground
////                           ⎩             ⎭
/**/
    {
/**/
        int mouseX=mouseX();
/**/
        int mouseY=mouseY();
        boolean mouseIsInTopRightCornerOfMonitor;
        boolean mouseIsInTopLeftCornerOfMonitor;
/**/
        //noinspection InfiniteLoopStatement
        while(true)
        {
/**/
            Thread.sleep(100);//Check at 10 Hertz
////                                                     ⎧                                            ⎫
////                                                     ⎪⎧                           ⎫               ⎪
////                                                     ⎪⎪          ⎧               ⎫⎪  ⎧           ⎫⎪
/**/
//⁠⁠⁠⁠⁠                                           ⎧                                            ⎫
//⁠⁠⁠⁠⁠                                           ⎪⎧                           ⎫               ⎪
//⁠⁠⁠⁠⁠                                           ⎪⎪          ⎧               ⎫⎪  ⎧           ⎫⎪
            mouseIsInTopRightCornerOfMonitor=((mouseX()==(ScreenWidth()-1))&&(mouseY()==0));
//⁠⁠⁠⁠⁠                                           ⎪⎪          ⎩               ⎭⎪  ⎩           ⎭⎪
//⁠⁠⁠⁠⁠                                           ⎪⎩                           ⎭               ⎪
//⁠⁠⁠⁠⁠                                           ⎩                                            ⎭
////                                                     ⎪⎪          ⎩               ⎭⎪  ⎩           ⎭⎪
////                                                     ⎪⎩                           ⎭               ⎪
////                                                     ⎩                                            ⎭
////                                                    ⎧                            ⎫
////                                                    ⎪⎧           ⎫  ⎧           ⎫⎪
/**/
            mouseIsInTopLeftCornerOfMonitor=((mouseX()==0)&&(mouseY()==0));
////                                                    ⎪⎩           ⎭  ⎩           ⎭⎪
////                                                    ⎩                            ⎭
////              ⎧                                                                                                           ⎫
////              ⎪⎧                                    ⎫                                                                     ⎪
////              ⎪⎪⎧                ⎫                  ⎪                                                                     ⎪
/**/
//⁠⁠⁠⁠⁠            ⎛                                                                                                           ⎞
//⁠⁠⁠⁠⁠            ⎜⎛                                    ⎞                                                                     ⎟
//⁠⁠⁠⁠⁠            ⎜⎜⎛                ⎞                  ⎟                                                                     ⎟
            if(((mouseX()!=mouseX)||mouseY!=mouseY())&&(mouseIsInTopLeftCornerOfMonitor!=mouseIsInTopRightCornerOfMonitor))//TAG:JAVA
//⁠⁠⁠⁠⁠            ⎜⎜⎝                ⎠                  ⎟                                                                     ⎟
//⁠⁠⁠⁠⁠            ⎜⎝                                    ⎠                                                                     ⎟
//⁠⁠⁠⁠⁠            ⎝                                                                                                           ⎠
////              ⎪⎪⎩                ⎭                  ⎪                                                                     ⎪
////              ⎪⎩                                    ⎭                                                                     ⎪
////              ⎩                                                                                                           ⎭
/**/
            {
                tic();
                for(int i=0;i<10;i++)
                {
//⁠⁠⁠⁠⁠                       ⎛      ⎞      ⎛      ⎞
//⁠⁠⁠⁠⁠                       ⎜⎛    ⎞⎟      ⎜⎛    ⎞⎟
//⁠⁠⁠⁠⁠                       ⎜⎜⎛  ⎞⎟⎟      ⎜⎜⎛  ⎞⎟⎟
                    //Mar(((()))))())))(((())))k a new sessionßß
//⁠⁠⁠⁠⁠                       ⎜⎜⎝  ⎠⎟⎟      ⎜⎜⎝  ⎠⎟⎟
//⁠⁠⁠⁠⁠                       ⎜⎝    ⎠⎟      ⎜⎝    ⎠⎟
//⁠⁠⁠⁠⁠                       ⎝      ⎠      ⎝      ⎠
                    System.out.println("==========================================================================================================");
                }
                String OldClipboardItem=StringFromClipboard();
/**/
//                Audio.waa();
/**/
                double KeyStrokeDelayTimeInSeconds=.05;//UserInput+﹢
/**÷
 int NumberOfUnindents=1;//UserInput++ (Number of indents that will be performed at a time. Note that setting this number very high will result in large delays, and setting it to low may also do the same (should find a balance. Under 5 should be good) Will continue to unindent until completion, though. So you don't have to worry about that.
 /**/                //region (Gears)
/**/
                final Robot robot=new Robot();//Used for the keystrokes
/**/
                final int MacCommandKey=KeyEvent.VK_META;
/**/                //region Set Eraser Mode Depending on whether mouse is on top left or top right corner of screen
/**/
                MakeParenthesis_drudgeon.EraserMode=mouseIsInTopRightCornerOfMonitor;//Because mouseIsInTopLeftCornerOfMonitor 🡩 !mouseIsInTopRightCornerOfMonitor
/**/                //endregion
/**/                //region Select all via 'Control' + 'A'
                int maxcounter=2;
                if(MakeParenthesis_drudgeon.EraserMode)
                {
                    counter++;
                }
                if(counter==maxcounter)
                {
                    HowtoDetermineWhatLanguageWeʹreReading
                        .ParenthesisAesthetical=!HowtoDetermineWhatLanguageWeʹreReading
                        .ParenthesisAesthetical;
                    MakeParenthesis_drudgeon.Parenthesis=new MakeParenthesis_drudgeon.Cartridge(HowtoDetermineWhatLanguageWeʹreReading.ParenthesisAesthetical?"⎨⎬⎧⎫⎪⎪⎩⎭":"()⎛⎞⎜⎟⎝⎠");
                }
                if(MakeParenthesis_drudgeon.EraserMode)
                {
                    if(counter>maxcounter)
                    {
                        Audio.GUI_Sound_A_Close_Slowed();
                    }
                    else
                    {
                        Audio.GUI_Sound_A_Open();
                    }
                }
                else
                {
                    counter=0;
                    Audio.GUI_Sound_A_Close();
                }
/**/
                int numberOfKeyMashesPerMashKeys=2;
                robot.keyPress(MacCommandKey);
/**/
                if(UniversalVariables.selectall)//Controlled by a tag that is remembered from session to session
                {
                    rapidlyMashKeys(robot,KeyStrokeDelayTimeInSeconds,numberOfKeyMashesPerMashKeys,KeyEvent.VK_A);
                }
                rapidlyMashKeys(robot,KeyStrokeDelayTimeInSeconds,numberOfKeyMashesPerMashKeys,KeyEvent.VK_C);
//                robot.keyRelease(MacCommandKey);
                String OriginalCopy=r.StringFromClipboard();
                if(OriginalCopy.contains("TAG:SLOW"))//For editors that can't keep up with the keystroke speed
                {
                    KeyStrokeDelayTimeInSeconds*=3;
                    KeyStrokeDelayTimeInSeconds+=.1;
                    System.out.println("TAG RECIEVED: SLOW : KeyStrokeDelayTimeInSeconds = "+KeyStrokeDelayTimeInSeconds);
                }
                boolean CopyOutput=OriginalCopy.contains("TAG:COPYOUTPUT");
                if(OriginalCopy.contains("SET:SELECTALL:TRUE"))
                {
                    UniversalVariables.selectall=true;
                }
                else if(OriginalCopy.contains("SET:SELECTALL:FALSE"))
                {
                    UniversalVariables.selectall=false;
                }
                if(OriginalCopy.contains("SET:DESELECT:FALSE"))
                {
                    UniversalVariables.deselect=false;
                }
                else if(OriginalCopy.contains("SET:DESELECT:TRUE"))
                {
                    UniversalVariables.deselect=true;
                }
                if(OriginalCopy.contains("SET:HIDELEVEL1:FALSE"))
                {
                    UniversalVariables.HideLevel1=false;
                    System.out.println("RECIEVED SET:HIDELEVEL1:FALSE");
                }
                else if(OriginalCopy.contains("SET:HIDELEVEL1:TRUE"))
                {
                    UniversalVariables.HideLevel1=true;
                    System.out.println("RECIEVED SET:HIDELEVEL1:TRUE");
                }
                UniversalVariables.IgnoreDoubles=OriginalCopy.contains("TAG:IGNORE()");
                //region AA bit redundant should refactor later but probably won't bother to.
                if(MakeParenthesis_drudgeon.Mode!=MakeParenthesis_drudgeon.AutomaticMode)
                {
                    MakeParenthesis_drudgeon.Spacefiller=MakeParenthesis_drudgeon.Mode[0];//Matlab: ";;;;"    Java: "/**/"
                    MakeParenthesis_drudgeon.Commentlinefiller=MakeParenthesis_drudgeon.Mode[1];//Matlab: "%%%%"   Java: "////"
                }
                else
                {
                    MakeParenthesis_drudgeon.Spacefiller="";
                    MakeParenthesis_drudgeon.Commentlinefiller=HowtoDetermineWhatLanguageWeʹreReading.languageGuessToCommentLine(OriginalCopy);
                }
                //endregion
/**/
                MakeParenthesis_drudgeon.main();//Takes copied text and replaces the output into the clipboard
/**/                //region Paste text via 'Control' + 'V'
/**/
                robot.keyPress(MacCommandKey);
                boolean NormalPasteShortcut=OriginalCopy.contains("TAG:NORAMLPASTE");
                if(!NormalPasteShortcut)
                {
                    robot.keyPress(KeyEvent.VK_ALT);//⌘ alt shift V because that's paste simple, not paste, letting us not worry about indents
                    robot.keyPress(KeyEvent.VK_SHIFT);
                }
                robot.keyPress(KeyEvent.VK_V);
/**/
                r.delay(KeyStrokeDelayTimeInSeconds);
                String OutputCode=r.StringFromClipboard();
/**/
/**/
//                r.delay(KeyStrokeDelayTimeInSeconds);
/**/                //endregion
/**/                //region Select all via 'Control' + 'A'
/**/
//                robot.keyPress(MacCommandKey);
///**/
//                robot.keyPress(KeyEvent.VK_A);
///**/
//                r.delay(KeyStrokeDelayTimeInSeconds);
///**/
//                robot.keyRelease(MacCommandKey);
///**/
//                robot.keyRelease(KeyEvent.VK_A);
///**/
//                r.delay(KeyStrokeDelayTimeInSeconds);
/**/                //endregion
/**/
//region We don't use this part anymore (Unindenter)
//                if(!MakeParenthesis_drudgeon.EraserMode)
///**/
//                {
//
/////region We don't un-indent anymore: The special paste option takes care of that for us.
////                    while(MakeParenthesis_drudgeon.PerformUnindents)
/////**/
////                    {
////////                           ⎧                                  ⎫
/////**/
////                        for(int i : new int[NumberOfUnindents])//Repeat 5 times
////////                           ⎩                                  ⎭
/////**/
////                        {
/////**/                            //region Un-Indent via 'Shift' + 'Tab'
/////**/
////                            robot.keyPress(KeyEvent.VK_SHIFT);
/////**/
////                            robot.keyPress(KeyEvent.VK_TAB);
/////**/
////                            r.delay(KeyStrokeDelayTimeInSeconds);
/////**/
////                            robot.keyRelease(KeyEvent.VK_SHIFT);
/////**/
////                            robot.keyRelease(KeyEvent.VK_TAB);
/////**/
////                            r.delay(KeyStrokeDelayTimeInSeconds);
/////**/                            //endregion
/////**/
////                        }
/////**/
////                        String OldClipboardString=StringFromClipboard();
/////**/                        //region Select all via 'Control' + 'A'
/////**/
////                        robot.keyPress(MacCommandKey);
/////**/
////                        robot.keyPress(KeyEvent.VK_A);
/////**/
////                        r.delay(KeyStrokeDelayTimeInSeconds);
/////**/
////                        robot.keyRelease(MacCommandKey);
/////**/
////                        robot.keyRelease(KeyEvent.VK_A);
/////**/
////                        r.delay(KeyStrokeDelayTimeInSeconds);
/////**/                        //endregion
/////**/                        //region Copy text via 'Control' + 'C'
/////**/
////                        robot.keyPress(MacCommandKey);
/////**/
////                        robot.keyPress(KeyEvent.VK_C);
/////**/
////                        r.delay(KeyStrokeDelayTimeInSeconds);
/////**/
////                        robot.keyRelease(MacCommandKey);
/////**/
////                        robot.keyRelease(KeyEvent.VK_C);
/////**/
////                        r.delay(KeyStrokeDelayTimeInSeconds);
/////**/                        //endregion
////////                          ⎧                                                ⎫
////////                          ⎪                         ⎧                     ⎫⎪
/////**/
////                        if(OldClipboardString.equals(StringFromClipboard()))//Keep doing intervals of indents until the code doesn't change any more.
////////                          ⎪                         ⎩                     ⎭⎪
////////                          ⎩                                                ⎭
/////**/
////                        {
/////**/
////                            break;
/////**/
////                        }
/////**/
////                    }
////endregion
///**/
//                }
                //endregion
/**/                //region Press left arrow key to deselect everything and go to beginning
/**/            //THE FOLLOWING SECTION WAS ORIGINALLY INTENDED FOR AN EASY-UNDO VIA REDO WHEN IT HAD TO USE SHIFT TAB OVER AND OVER.
                //BUT, now, because I know about Intellij's 'Simple Paste', I don't have to worry about that anymore. It speeds things up a lot.
                //That's why its commented out.
//                StringToClipboard(OriginalCopy);
/**/                //region Paste text via 'Control' + 'V'
/**/
                /*robot.keyPress(MacCommandKey);
*//**//*
                robot.keyPress(KeyEvent.VK_V);
*//**//*
                r.delay(KeyStrokeDelayTimeInSeconds);
*//**//*
                robot.keyRelease(MacCommandKey);
*//**//*
                robot.keyRelease(KeyEvent.VK_V);
*//**//*
                r.delay(KeyStrokeDelayTimeInSeconds);*/
/**/                //endregion
/**/                //region Undo Paste text via 'Control' + 'Z'
/**/
                /*robot.keyPress(MacCommandKey);
*//**//*
                robot.keyPress(KeyEvent.VK_Z);
*//**//*
                r.delay(KeyStrokeDelayTimeInSeconds);
*//**//*
                robot.keyRelease(MacCommandKey);
*//**//*
                robot.keyRelease(KeyEvent.VK_Z);
*//**//*
                r.delay(KeyStrokeDelayTimeInSeconds);*/
/**/                //endregion
/**/                //NOW IF YOU WANT TO UNDO THIS YOU CAN SIMPLY REDO.



/**/
/**/                //endregion
/**/
//                Audio.waa();
                if(MakeParenthesis_drudgeon.EraserMode)
                {
                    Audio.GUI_SingleClick();
                }
                else
                {
                    Audio.GUI_QuietDoubleClick();
                }
/**÷
 *
 */
                robot.keyRelease(MacCommandKey);
                if(!NormalPasteShortcut)
                {
                    robot.keyRelease(KeyEvent.VK_ALT);
                    robot.keyRelease(KeyEvent.VK_SHIFT);
                }
                robot.keyRelease(KeyEvent.VK_V);
//                    r.delay(KeyStrokeDelayTimeInSeconds);
                if(UniversalVariables.deselect)
                {
                    robot.keyPress(KeyEvent.VK_LEFT);
                    r.delay(KeyStrokeDelayTimeInSeconds);
                    robot.keyRelease(KeyEvent.VK_LEFT);
                }
                StringToClipboard(OldClipboardItem);
                if(CopyOutput)
                {
                    //Dont' deseelct text
                    StringToClipboard(OutputCode);
                    StringToClipboard(OutputCode);
                    System.out.println(StringFromClipboard()+"UP");
                }
//                r.delay(0);//We don't want this happening too frequently. Defensive Nintendo command here.
/**/                //StringToClipboard(OldClipboardItem); ⌘
                ptoc();
            }

/**/            //region (Gears) Remember Mouse Position
/**/
            mouseX=mouseX();
/**/
            mouseY=mouseY();
/**/            //endregion
/**/
        }
/**/
    }
/**/
}
@SuppressWarnings({"SpellCheckingInspection","Duplicates"})
class MakeParenthesis_drudgeon
{
    //region Settings UserInput++ //TODO
    static boolean PerformUnindents=false;
    static final boolean ReplaceInsteadOfShift=true;
    static final String[] MatlabMode=new String[]{";;;;","%;\u2060;%"};//The \u2060 is my secret sauce. It's what prevents my comments from being mistaken for other peoples'. \u2060 is an invisible character that takes up no space.
    static final String[] JavaMode=new String[]{"/*\u2060*/","//\u2060//"};
    static final String[] PythonMode=new String[]{"","#\u2060"};
    static final String[] AutomaticMode=new String[]{};
    static String[] Mode=AutomaticMode;//Either JavaMode or MatlabMode
    static Cartridge Parenthesis=new Cartridge(HowtoDetermineWhatLanguageWeʹreReading.ParenthesisAesthetical?"()⎧⎫⎪⎪⎩⎭":"()⎛⎞⎜⎟⎝⎠");// VS new Cartridge("()⎛⎞⎜⎟⎝⎠");       An optional alternative parenthesis style that can be enabled or disabled by commenting or uncommenting this line
    static boolean PrettyParenthesis=false;//If false then the code will still be runnable as is. (This is the default). Otherwise, If true, then the entire thing is one giant comment, but it looks cleaner. Use this for small comments to explain, but not the whole code all at once if true.
    //endregion
    //region (Gears)
    //region (Gears)
    //region Min and Max Methods
    static boolean EraserMode=false;//Only works if we didn't use prettyparentheis. Basically it undoes what we might have done to the code before.
    private static int min(int... x)
    {
        assert x.length>0;
        int out=Integer.MAX_VALUE;
        for(int y : x)
        {
            if(y<out)
            {
                out=y;
            }
        }
        return out;
    }
    private static int max(int... x)
    {
        assert x.length>0;
        int out=-Integer.MAX_VALUE;
        for(int y : x)
        {
            if(y>out)
            {
                out=y;
            }
        }
        return out;
    }
    //endregion
    //region Cartridge Class
    static class Cartridge
    {
        //Contains all the data to make large, nested parenthesis; like one of those 80's printing press-printer wheel thingies
        final char RegLeft, RegRight;//Regular Character
        final char TopLeft, TopRight;//Unicode Top
        final char MidLeft, MidRight;//Unicode Mid
        final char BotLeft, BotRight;//Unicode Bottom
        Cartridge(String regL_regR_topL_topR_midL_midR_botL_botR)
        {
            assert regL_regR_topL_topR_midL_midR_botL_botR.length()==8;//This is how many characters we need
            RegLeft=regL_regR_topL_topR_midL_midR_botL_botR.charAt(0);
            RegRight=regL_regR_topL_topR_midL_midR_botL_botR.charAt(1);
            TopLeft=regL_regR_topL_topR_midL_midR_botL_botR.charAt(2);
            TopRight=regL_regR_topL_topR_midL_midR_botL_botR.charAt(3);
            MidLeft=regL_regR_topL_topR_midL_midR_botL_botR.charAt(4);
            MidRight=regL_regR_topL_topR_midL_midR_botL_botR.charAt(5);
            BotLeft=regL_regR_topL_topR_midL_midR_botL_botR.charAt(6);
            BotRight=regL_regR_topL_topR_midL_midR_botL_botR.charAt(7);
        }
    }
    //endregion
    //region Parenthesis Draw Method
//    public static boolean PrettyParenthesis=false;
    public static String Spacefiller="/**/";//Because regular spaces don't work in intellij
    public static String Commentlinefiller="////";//Must be same length as spacefiller
    //    public static Cartridge Parenthesis=new Cartridge("()⎛⎞⎜⎟⎝⎠");
    public static String MakeParenthesis(String InputString,int... Levels)
    {
        /*String InputString="(((∴ )))";
        int[] Levels=new int[]{5,2,1,0,0,-1,-2,-4};*/
        int MinLevel=min(Levels), MaxLevel=max(Levels);
        //region Assertions
        assert Levels.length==InputString.length();//Remember that Levels must be derived from InputString, so they should be the same length
        assert MaxLevel>=0;
        assert MinLevel<=0;
        if(!ReplaceInsteadOfShift)
        {
            assert Spacefiller.length()==Commentlinefiller.length();
        }
        //assert MinLevel==-MaxLevel;
        //endregion
        //region Brainstorm
        /*0->1
          1->1
          2->3
          3->5
          4->7*/
        //endregionk
        char[][] Canvas/*In [row][column] form, not [x][y] form*/=new char[MaxLevel==0?1:2*MaxLevel+1/*Determine how many layers of strings we need to display the parenthesis we are given*/][Levels.length];
        int MidLevel=Canvas.length/2;//It's really more like canvas height/2
        //region Draw Parenthesis on Canvas
        int ColumnNumber=0;
        for(int Level : Levels)
        {
            if(Level>0)//LeftParenthesis > 0
            {
                // Level=Math.max(Level-1,0);
                Canvas[MidLevel-Level][ColumnNumber]=Parenthesis.BotLeft;
                for(int RowNumber=1-Level;RowNumber<Level;RowNumber++)//Build the | part of the big parenthesis
                {
                    Canvas[MidLevel+RowNumber][ColumnNumber]=Parenthesis.MidLeft;
                }
                Canvas[MidLevel+Level][ColumnNumber]=Parenthesis.TopLeft;
            }
            if(Level<0)
            {
                Level*=-1;//<-- Same exact thing as above, except now with level=-level
                //Level=Math.max(Level-1,0);
                Canvas[MidLevel-Level][ColumnNumber]=Parenthesis.BotRight;
                for(int RowNumber=1-Level;RowNumber<Level;RowNumber++)//Build the | part of the big parenthesis
                {
                    Canvas[MidLevel+RowNumber][ColumnNumber]=Parenthesis.MidRight;
                }
                Canvas[MidLevel+Level][ColumnNumber]=Parenthesis.TopRight;
            }
            ColumnNumber++;
        }
        Canvas[MidLevel]=InputString.toCharArray();// Because we already asserted that ( InputString.length() == Canvas.[n].length  (∀ n ∈ [0,Canvas.length-1] ⋂ Z) )
        //region If we want to make the whole thing a big comment rather than code, we can make it prettier...
        if(PrettyParenthesis)
        {
            int j=0;
            for(char z : Canvas[MidLevel])
            {
                if(z==Parenthesis.RegLeft&&Math.abs(((((((((Levels[j])))))))))>0)
                {
                    Canvas[MidLevel][j]=Parenthesis.MidLeft;
                }
                if(z==Parenthesis.RegRight&&Math.abs(Levels[j])>0)
                {
                    Canvas[MidLevel][j]=Parenthesis.MidRight;
                }
                j++;
            }
        }
        //endregion
        //endregion
        String out="";
        for(int i=Canvas.length-1;i>=0;i--)
        {// a ⋀ ¬b
            char[] x=Canvas[i];
            boolean temp=(i==MidLevel)&&!PrettyParenthesis;
            if(ReplaceInsteadOfShift)
            {
                if(!temp)
                {
                    //First we must determine the number of characters that are not blank…
                    int NumberOfNonBlankCharacters=0;
                    for(char c : Commentlinefiller.toCharArray())
                    {
                        if(c!='\u2060')
                        {
                            NumberOfNonBlankCharacters++;
                        }
                    }
                    for(int I=0;I<NumberOfNonBlankCharacters;I++)//basically just erase them
                    {
                        x[I]='\u2060';
                    }
                }
            }
            {
                out+=temp?Spacefiller:Commentlinefiller;
            }
            for(char y : x)
            {
                out=out+(y=='\u0000'?' ':y);
            }
//            if(ReplaceInsteadOfShift)
//            {
//                if(!temp)
//                {
//                    //First we must determine the number of characters that are not blank…
//                    int NumberOfNonBlankCharacters=0;
//                    for(char c:Commentlinefiller.toCharArray())
//                        if(c!='\u2060')
//                            NumberOfNonBlankCharacters++;
//
//                    //out=Commentlinefiller+out.substring();
//                    out="APPLE"+out;
//                }
//            }
            if(i!=0)
            {
                out+='\n';
            }
        }
        return out;
    }
    //endregion
    //region (Get Parenthesis Levels From String) Method
    public static int[] GetLevels(String input)
    {
        return OLDparenthesisScrapNewAlgorithmTest.GenerateParenthesisLevels(input);
        //region The FAR simpler, but cruder version:
//        int[] Levels=new int[input.length()];
//        int Level=0;
//        for(int i=0;i<Levels.length;i++)
//        {
//            if(input.charAt(i)=='(')
//            {
//                Levels[i]=++Level;
//            }
//            else if(input.charAt(i)==')')
//            {
//                Levels[i]=-Level--;
//            }
//            else
//            {
//                Levels[i]=0;
//            }
//        }
//        int MaxLevel=max(Levels);
//
//        int i=0;
//        for(int x:Levels)
//            Levels[i++]=(int)((MaxLevel-Math.abs(x))*Math.signum(x));
//        return Levels;
        //endregion
    }
    //endregion
    //endregion
    //region (Gears)
    public static void main(String... args) throws Exception
    {
        //region (Gears)
        //TODO: Make parenthesis size correctly for ((())())
        //WARNING: Multi-Lined Java block comments are known to break this algorithm.
        //Copy code to clipboard. Run this code. Paste code back where you found it.
        //To undo: use regex search/replace with "[%][%][%][%].*[\n]" --> ""    and then  not-regex search/replace of ";;;;" --> ""
        //region Various unicode junk
        //❴{}❵
        //∆chicken
        //    ⎧  ⎫
        //    ⎪  ⎪
        //    ⎨  ⎬ {}
        //    ⎪  ⎪
        //    ⎩  ⎭
        //
        //    ⎞⎛⁽⁾          ⎞
        //    ⎟⎜(Apple) +   ⎟
        //    ⎠⎝₍₀₁₂₃₄₅₆₇₈₉₎⎠
        //็็็็็็็็็็็็็็็็็็็็็็็็็็็็aar
        //    ⎛(a)⎞
        //    ⎜(b)⎟
        //    ⎝(c)⎠
        //
        //endregion
        //endregion
        //region (Gears﹚
//        Audio.waa();
        String test=r.StringFromClipboard();
        //region Undo any parenthesis we might have put on there before using the regex eraser method mentioned in the instructions...
        //;O:;;;O(for)OO;;;O(for)OO
        String RegexReplacement;
        RegexReplacement="";
        for(char x : Commentlinefiller.toCharArray())
        {
            RegexReplacement+="["+x+"]";
        }
        RegexReplacement+=".*[\\n]";
        test=test.replaceAll(RegexReplacement,"");
        RegexReplacement="";
        for(char x : Spacefiller.toCharArray())
        {
            RegexReplacement+="["+x+"]";
        }
        test=test.replaceAll(RegexReplacement,"");
        //endregion
        if(!EraserMode)
        {
            String[] Lines=test.split("\n");
            String out="";
            for(String x : Lines)
            {
                try
                {
                    String tobeadded=(x.equals("")?"":MakeParenthesis(x,GetLevels(x)))+"\n";
                /*if(tobeadded.split("\n").length>1)//If we want to separate each equation section with an empy
                    if(out.charAt(out.length()-1)!='\n')
                        tobeadded="\n"+tobeadded+"\n";
                    else
                        tobeadded=tobeadded+"\n";*/
                    out+=tobeadded;
                }
                catch(Exception ig)
                {
                }
            }
            System.out.println(out);
            r.StringToClipboard(out);
        }
        else
        {
            System.out.println(test);
            r.StringToClipboard(test);
        }
//        Audio.waa();
        //endregion
    }
    //endregion
    //endregion
}
//region IGNOREME
/**/
@SuppressWarnings({"WeakerAccess","Duplicates"})
class parenthesisScrapNewAlgorithmTest extends MakeParenthesis_drudgeon
/**/
{
    ////                                    ⎧            ⎫
/**/
    public static void printintarray(int[] Levels)
////                                    ⎩            ⎭
/**/
    {
/**/
        String out="";
/**/
        for(int x : Levels)
/**/
        {
/**/
            out+=x;
/**/
        }
/**/
        System.out.println(out);
/**/
    }
    ////                                              ⎧            ⎫
/**/
    public static void printintarraywithspaces(int[] Levels)
////                                              ⎩            ⎭
/**/
    {
/**/
        String out="";
/**/
        for(int x : Levels)
/**/
        {
/**/
            out+=x+" ";
/**/
        }
/**/
        System.out.println(out);
/**/
    }
    /**/
    public static int nextCharIndex(String x,char c,int initialindex)
/**/
    {
////           ⎧                                   ⎫
/**/
        try
        {
            return x.indexOf(c,initialindex+1);
        }
////           ⎩                                   ⎭
/**/        //region junk
////                                     ⎧            ⎫
/**/
        catch(Exception ignoredb)
        {
            try
            {
                Audio.waa();
            }
            catch(Exception ignored)
            {
            }
////                                     ⎩            ⎭
/**/
            System.out.println("MADE SOME SORTA ERROR HERE!!! IT's an internal logic problem, not due to external noise. Remove me if I never show up during testing.");
            return initialindex;
        }
/**/        //endregion
/**/
    }
    /**/
    public static boolean seesGoodCharacterBeforeAnyOfTheseBadCharacters(String context,int index,char good,char... bad)
/**/
    {
////                                                      ⎧                                                    ⎫
////                                                      ⎪                 ⎧                        ⎫         ⎪
/**/
        return goodCharacterIsToLeftOfAllBadCharacters(context.substring(index+1,context.length()),good,bad);
////                                                      ⎪                 ⎩                        ⎭         ⎪
////                                                      ⎩                                                    ⎭
/**/
    }
    /**/
    public static boolean goodCharacterIsToLeftOfAllBadCharacters(String context,char good,char... bad)
/**/
    {
////           ⎧                            ⎫
/**/
        for(char c : context.toCharArray())
////           ⎩                            ⎭
/**/
        {
            if(c==good)
/**/
            {
                return true;
            }
////                   ⎧                    ⎫
/**/
            else if(isAnElementOf(c,bad))
////                   ⎩                    ⎭
/**/
            {
                return false;
            }
        }
/**/        //We have reached this point ⟹ that 'context' contains no good or bad characters, I.E. ...
/**/        // ...  ∴ ∀ char ∈ context, char ∉ good ⋃ bad
/**/
        return false;//The default response in this scenario
/**/
    }
    ////                             ⎧              ⎫
/**/
    public static int[] append(int[] a,int... b)
////                             ⎩              ⎭
/**/
    {
/**/
        int[] out=new int[a.length+b.length];
/**/
        System.arraycopy(a,0,out,0,a.length);
/**/
        System.arraycopy(b,0,out,a.length,b.length);
/**/
        return out;
/**/
    }
    ////                               ⎧                  ⎫
/**/
    public static int[][] append(int[][] a,int[]... b)
////                               ⎩                  ⎭
/**/
    {
/**/
        int[][] out=new int[a.length+b.length][];
/**/
        System.arraycopy(a,0,out,0,a.length);
/**/
        System.arraycopy(b,0,out,a.length,b.length);
/**/
        return out;
/**/
    }
    /**/
    public static boolean isAnElementOf(int a,int... b)
/**/
    {
/**/        //returns a ∈ b
/**/
        for(int c : b)
/**/
        {
            if(a==c)
/**/
            {
                return true;
            }
        }
/**/
        return false;
/**/
    }
    /**/
    public static boolean isAnElementOf(char a,char... b)
/**/
    {
/**/        //returns a ∈ b
/**/
        for(char c : b)
/**/
        {
            if(a==c)
/**/
            {
                return true;
            }
        }
/**/
        return false;
/**/
    }
    /**/
    public static int[] GenerateParenthesisLevels(String input)
/**/
    {
/**/
/**/
        int[][] AllLevels=new int[0][0];
/**/
        char empty='◌';
        String originalinput=input;
        System.out.println(originalinput);//ring
        if(UniversalVariables.IgnoreDoubles)
        {
            originalinput=UML_Generator_Curvy.ExecuteRules(input,2,UML_Generator_Curvy.Rule(x->x.equals("()")||x.equals("{}")||x.equals("[]"),y->"⨀⨀"));
            input=originalinput;
        }


/**/        //ONLY GENERALIZED FOR () RIGHT NOW
/**/        //FOR LOOP:
/**/
        char[] BadCharacters=new char[]{'(','[','{'};
/**/
        char[] GoodCharacters=new char[]{')',']','}'};
/**/
        while(true)
/**/
        {
/**/
            int[] ThisLevel=new int[0];
/**/
            int index=0;
////               ⎧                            ⎫
/**/
            for(char c : input.toCharArray())
////               ⎩                            ⎭
/**/
            {
////                  ⎧                              ⎫
/**/
                if(isAnElementOf(c,BadCharacters))
////                  ⎩                              ⎭
/**/
                {
/**/
                    char conjugate=c=='('?')':c=='['?']':'}';
////                      ⎧                                                                                   ⎫
/**/
                    if(seesGoodCharacterBeforeAnyOfTheseBadCharacters(input,index,conjugate,BadCharacters))
////                      ⎩                                                                                   ⎭
/**/
                    {
////                                        ⎧                                                    ⎫
/**/
                        ThisLevel=append(ThisLevel,index,nextCharIndex(input,conjugate,index));
////                                        ⎩                                                    ⎭
/**/
                    }
/**/
                }
/**/
                index++;
/**/
            }
/**/            //And now to fill each of the chars in the string with the empties:
/**/
            String newinput="";
/**/
            int i=0;
////               ⎧                            ⎫
/**/
            for(char c : input.toCharArray())
////               ⎩                            ⎭
/**/
            {
////                  ⎧                          ⎫
/**/
                if(isAnElementOf(i,ThisLevel))
////                  ⎩                          ⎭
/**/
                {
/**/
                    newinput+=empty;
/**/
                }
/**/
                else
/**/
                {
/**/
                    newinput+=c;
/**/
                }
/**/
                i++;
/**/
            }
////                                          ⎧                      ⎫
/**/
            assert (ThisLevel.length==0)==(input.equals(newinput));//an internal logic assertion. not a input-noise one.
////                                          ⎩                      ⎭
/**/
            if(ThisLevel.length==0)
/**/
            {
                break;
            }

/**/
            input=newinput;
/**/
            AllLevels=append(AllLevels,ThisLevel);

/**/            //The next two lines of code are purely for visualization purposes to see if this algorithm produced what I had drawn on paper.
/**/            //PLEASE DO NOT DELETE! JUST COMMENT OR UNCOMMENT THEM.
/**/
            printintarraywithspaces(ThisLevel);
/**/
            System.out.println(newinput);
/**/
        }

/**/        //Now that we have our level diagram, we can construct the level
////                           ⎧              ⎫
/**/
        int[] output=new int[input.length()];
////                           ⎩              ⎭
/**/
        int levelnumber=1;
////           ⎧                    ⎫
/**/
        for(int[] level : AllLevels)
////           ⎩                    ⎭
/**/
        {
/**/
            for(int associatedcharcolumn : level)
/**/
            {
/**/
                output[associatedcharcolumn]=levelnumber;
/**/
            }
/**/
            levelnumber++;
/**/
        }
/**/
        System.out.println("");
/**/
        System.out.println("FINAL OUTPUT:");
/**/
        printintarray(output);
/**/
        System.out.println(originalinput);

/**/        //THIS CODE IS NOW CAPABLE OF HANDLING MORE THAN JUST ()'s.
/**/        //HERE'S THE CHEAP AND DIRTY CONVERSION CODE TO MAKE IT COMPATIBLE WITH THE PREVIOUS VERSION:
/**/        //region cheapn'dirty
/**/
        int i=0;
////           ⎧                                  ⎫
/**/
        for(char c : originalinput.toCharArray())
////           ⎩                                  ⎭
/**/
        {
/**/
            output[i]--;
////              ⎧           ⎫
/**/
            if(output[i]<0)
////              ⎩           ⎭
/**/
            {
                output[i]=0;
            }
////              ⎧                               ⎫
/**/
            if(isAnElementOf(c,GoodCharacters))
////              ⎩                               ⎭
/**/
            {
/**/
                output[i]*=-1;
/**/
            }
/**/
            i++;
/**/
        }
/**/        //endregion

/**/
        return output;

/**/
    }
    ////                           ⎧            ⎫
/**/
    public static void main(String[] args)
////                           ⎩            ⎭
/**/
    {
////                      ⎧         ⎫
////                      ⎪⎧   ⎫    ⎪
/**/
        String input="(((a))+(b))";
////                      ⎪⎩   ⎭    ⎪
////                      ⎩         ⎭
/**/
        GenerateParenthesisLevels(input);
/**/
    }

/**/
}
////                            ⎧                                               ⎫
////                            ⎪               ⎧                              ⎫⎪
////                            ⎪               ⎪      ⎧                      ⎫⎪⎪
/**///        System.out.println(Arrays.toString(append(new int[]{1,2,3},4,5,6)));
////                            ⎪               ⎪      ⎩                      ⎭⎪⎪
////                            ⎪               ⎩                              ⎭⎪
////                            ⎩                                               ⎭
/**///
////                            ⎧                                                                    ⎫
////                            ⎪                                              ⎧              ⎫      ⎪
/**///        System.out.println(seesGoodCharacterBeforeAnyOfTheseBadCharacters("...(...)",3,')','('));
////                            ⎪                                              ⎩              ⎭      ⎪
////                            ⎩                                                                    ⎭
////                                                                           ⎧                      ⎫
////                                                                           ⎪    ⎧          ⎫      ⎪
/**///        System.out.println(seesGoodCharacterBeforeAnyOfTheseBadCharacters("...(..(.)",4,')','('));
////                                                                           ⎪    ⎩          ⎭      ⎪
////                                                                           ⎩                      ⎭
////                                                                                ⎧          ⎫
/**///        System.out.println(seesGoodCharacterBeforeAnyOfTheseBadCharacters("...(..(.)",4,')','(','['));
////                                                                                ⎩          ⎭
/**///region scrapped
////                           ⎧                           ⎫
////                           ⎪   ⎧           ⎫           ⎪
/**///        String input="...(...(...(...)...)...(...)...)...";
////                           ⎪   ⎩           ⎭           ⎪
////                           ⎩                           ⎭
////                             ⎧              ⎫
/**///        int[]Levels=new int[input.length()];
////                             ⎩              ⎭
/**///        int i=0;
////             ⎧                          ⎫
/**///        for(char c:input.toCharArray())
////             ⎩                          ⎭
/**///        {
/**///            int a=nextCharIndex(input,'(',i);
/**///            int b=nextCharIndex(input,')',i);
/**///            if(a<b)
/**///            {
/**///                Levels[a]=++Levels[b];
/**///            }
/**///            i++;
/**///        }
/**///        printintarray(Levels);
/**///endregion
/**///region Scrapped
////                                      ⎧            ⎫
/**///    public static void printintarray(int[] Levels)
////                                      ⎩            ⎭
/**///    {
/**///        String out="";
/**///        for(int x : Levels)
/**///        {
/**///            out+=x;
/**///        }
/**///        System.out.println(out);
/**///    }
////                             ⎧             ⎫
/**///    public static void main(String[] args)
////                             ⎩             ⎭
/**///    {
////                        ⎧      ⎫
////                        ⎪⎧  ⎫  ⎪
/**///        String input="((())())";
////                        ⎪⎩  ⎭  ⎪
////                        ⎩      ⎭
/**///
/**///        //region Parenthesis Counter -> int[]Levels
/**///        char[]inputarray=input.toCharArray();
/**///        int Level=0,MaxLevelMagnitude=0,i=0,length=input.length();
/**///        int[] Levels=new int[length];
/**///        for(char c : inputarray)
/**///        {
/**///            //region (Expanded version of next line)
/**///            //            if(c=='(')
/**///            //            {
/**///            //                Levels[i++]=++Level;
/**///            //            }
/**///            //            else if(c==')')
/**///            //            {
/**///            //                Levels[i++]=Level--;
/**///            //            }
/**///            //            else
/**///            //            {
/**///            //                Levels[i++]=0;
/**///            //            }
/**///            //endregion
/**///region a
/**///            Levels[i++]=c=='('?++Level:c==')'?Level--:0;
////                                        ⎧                                 ⎫
/**///            MaxLevelMagnitude=Math.max(MaxLevelMagnitude,Math.abs(Level));
////                                        ⎩                                 ⎭
/**///        }
/**///        //endregion
/**///        //programming forces you to only look at the small picture........
/**///        //........I don't want to become a programmer..........though, it IS rather zen-like; meditative even......
/**///
/**///        System.out.println(input);
/**///        printintarray(Levels);
/**///        System.out.println(MaxLevelMagnitude);
/**///
/**///        for(i=0;i<length-1;i++)
/**///        {
////                                 ⎧                         ⎫
/**///            if(inputarray[i]=='('&&Levels[i]==Levels[i+1])
////                                 ⎩                         ⎭
/**///            {
/**///                Levels[i]=Levels[i+1]=0;
/**///            }
/**///        }
/**///        printintarray(Levels);
/**///
/**///endregion
//endregion
/**
 * A simple Java sound file example (i.e., Java code to play a sound file).
 * AudioStream and AudioPlayer code comes from a javaworld.com example.
 *
 * @author alvin alexander, devdaily.com.
 */
@SuppressWarnings("WeakerAccess")
class Audio extends r
{
    public static void PlaySound(String FileName) throws Exception
    {
    }
    public static int[] LastWaaNumbers={0,0,0,0,0};
    public static void waa() throws Exception
    {
        //Got nintendo sounds from this library: http://themushroomkingdom.net/media/smw/wav
        int WaaNumber=5;
        boolean PlayedThisWaaNumberRecently=true;
        while(PlayedThisWaaNumberRecently)
        {
            PlayedThisWaaNumberRecently=false;//Will turn true and continue the loop if it doesn't pass the array check test...
            WaaNumber=1+randomInt(10);
            for(int i : LastWaaNumbers)
            {
                if(i==WaaNumber)
                {
                    PlayedThisWaaNumberRecently=true;
                }
            }
        }
        LastWaaNumbers=new int[]{WaaNumber,LastWaaNumbers[0],LastWaaNumbers[1],LastWaaNumbers[2],LastWaaNumbers[3]};
        //println(WaaNumber); //<-- Notice how it will never play a number that it's played within 5 times before! IE, no repeats.
    }
    //region Valid Sounds Effects
    public static void GUI_Sound_A_Open()
    {
        try
        {
        }
        catch(Exception ignored)
        {
        }
    }
    public static void GUI_Sound_A_Close()
    {
        try
        {
            PlaySound("/Users/Ryan/Google Drive/Exobyte Stony Brook Nexus/Java Programs/Ryan B Standards/Non-Java Files/Sounds/GUI/Effect A Close.wav");
        }
        catch(Exception ignored)
        {
        }
    }
    public static void GUI_SingleClick()
    {
        try
        {
            PlaySound("/Users/Ryan/Google Drive/Exobyte Stony Brook Nexus/Java Programs/Ryan B Standards/Non-Java Files/Sounds/GUI/SingleClick.wav");
        }
        catch(Exception ignored)
        {
        }
    }
    public static void GUI_DoubleClick()
    {
        try
        {
            PlaySound("/Users/Ryan/Google Drive/Exobyte Stony Brook Nexus/Java Programs/Ryan B Standards/Non-Java Files/Sounds/GUI/DoubleClick.wav");
        }
        catch(Exception ignored)
        {
        }
    }
    public static void GUI_QuietDoubleClick()
    {
        try
        {
            PlaySound("/Users/Ryan/Google Drive/Exobyte Stony Brook Nexus/Java Programs/Ryan B Standards/Non-Java Files/Sounds/GUI/QuietDoubleClick.wav");
        }
        catch(Exception ignored)
        {
        }
    }
    public static void GUI_Sound_A_Close_Slowed()
    {
        try
        {
            PlaySound("/Users/Ryan/Google Drive/Exobyte Stony Brook Nexus/Java Programs/Ryan B Standards/Non-Java Files/Sounds/GUI/Effect A Close Slowed.wav");
        }
        catch(Exception ignored)
        {
        }
    }
    //endregion
    public static void main(String[] args)
        throws Exception
    {
        // open the sound file as a  Java input stream
        String gongFile="/Users/Ryan/Desktop/Untitled.wav";
        PlaySound(gongFile);
//        new FileInputStream("/Users/Ryan/Desktop/Untitled.wav");
        InputStream in=new FileInputStream(gongFile);
        // create an audiostream from the inputstream
        AudioStream audioStream=new AudioStream(in);
        // play the audio clip with the audioplayer class
        while(true)
        {
            //PlaySound("http://themushroomkingdom.net/sounds/wav/mparty8/mparty8_waluigi_06.wav");
            if(scan().toLowerCase().equals("waa"))
            {
                waa();
            }
            else
            {
                println("Say \"Waa\"!");
            }
            //delay(1);
            //waa();
        }
    }
}
/**
 * Created by Ryan B on 2/7/16.
 * <p>
 * This is a class that can be easily extended, or copied and pasted into, any other class.
 * It contains many shorthand notations for otherwise annoyingly verbose methods, and offers
 * additional functionality such as complex mathematical operations and inverse hyperbolic trig.
 */
//region UML (May be outdated)
//    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
//    ┃ r                                                                     ┃
//    ┠───────────────────────────────────────────────────────────────────────┨
//    ┃ - Complex : class                                                     ┃
//    ┃ - DEG_PER_RAD : double                                                ┃
//    ┃ - DEG_TO_RAD : double                                                 ┃
//    ┃ - E : double                                                          ┃
//    ┃ - PI : double                                                         ┃
//    ┃ - RAD_PER_DEG : double                                                ┃
//    ┃ - RAD_TO_DEG : double                                                 ┃
//    ┃ - TWO_PI : double                                                     ┃
//    ┠┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┨
//    ┃ + abs(x:Complex) : double                                             ┃
//    ┃ + abs(x:double) : double                                              ┃
//    ┃ + acos(x:double) : double                                             ┃
//    ┃ + acosh(x:double) : double                                            ┃
//    ┃ + acot(x:double) : double                                             ┃
//    ┃ + acoth(x:double) : double                                            ┃
//    ┃ + acsc(x:double) : double                                             ┃
//    ┃ + acsch(x:double) : double                                            ┃
//    ┃ + add(a:double, b:double, x:double, y:double) : Complex               ┃
//    ┃ + add(X:Complex, Y:Complex) : Complex                                 ┃
//    ┃ + angleOf(x:double, y:double) : double                                ┃
//    ┃ + arg(x:Complex) : double                                             ┃
//    ┃ + asec(x:double) : double                                             ┃
//    ┃ + asech(x:double) : double                                            ┃
//    ┃ + asin(x:double) : double                                             ┃
//    ┃ + asinh(x:double) : double                                            ┃
//    ┃ + atan(x:double) : double                                             ┃
//    ┃ + atanh(x:double) : double                                            ┃
//    ┃ + avg() : double                                                      ┃
//    ┃ + avg() : double                                                      ┃
//    ┃ + Boolean(x:int) : boolean                                            ┃
//    ┃ + booleanScan() : boolean                                             ┃
//    ┃ + ceil(x:double) : long                                               ┃
//    ┃ + chance(Probability:double) : boolean                                ┃
//    ┃ + complex(real:double, imag:double) : Complex                         ┃
//    ┃ + cos(x:double) : double                                              ┃
//    ┃ + cosh(x:double) : double                                             ┃
//    ┃ + cot(x:double) : double                                              ┃
//    ┃ + coth(x:double) : double                                             ┃
//    ┃ + csc(x:double) : double                                              ┃
//    ┃ + csch(x:double) : double                                             ┃
//    ┃ + delay(delayDurationInSeconds:double) : void                         ┃
//    ┃ + delayInMillis(delayDurationInMilliseconds:long) : void              ┃
//    ┃ + distance(X:double, Y:double, x:double, y:double) : double           ┃
//    ┃ + div(a:double, b:double, x:double, y:double) : Complex               ┃
//    ┃ + div(X:Complex, Y:Complex) : Complex                                 ┃
//    ┃ + Double(Input:String) : double                                       ┃
//    ┃ + doubleArray() : double[]                                            ┃
//    ┃ + doubleScan() : double                                               ┃
//    ┃ + exp(a:double, b:double) : Complex                                   ┃
//    ┃ + exp(X:Complex) : Complex                                            ┃
//    ┃ + exp(x:double) : double                                              ┃
//    ┃ + factorial(x:long) : long                                            ┃
//    ┃ + floatScan() : float                                                 ┃
//    ┃ + floor(x:double) : long                                              ┃
//    ┃ + im(imag:double) : Complex                                           ┃
//    ┃ + im(x:Complex) : double                                              ┃
//    ┃ + imag(imag:double) : Complex                                         ┃
//    ┃ + imag(x:Complex) : double                                            ┃
//    ┃ + Int(Input:String) : double                                          ┃
//    ┃ + Int(x:boolean) : int                                                ┃
//    ┃ + intScan() : int                                                     ┃
//    ┃ + ln(a:double, b:double) : Complex                                    ┃
//    ┃ + ln(X:Complex) : Complex                                             ┃
//    ┃ + ln(x:double) : double                                               ┃
//    ┃ + log(Base:Complex, X:Complex) : Complex                              ┃
//    ┃ + log(Base_a:double, Base_b:double, X_x:double, X_y:double) : Complex ┃
//    ┃ + Long(Input:String) : double                                         ┃
//    ┃ + longScan() : long                                                   ┃
//    ┃ + mag(x:double, y:double) : double                                    ┃
//    ┃ + max(x:double, y:double) : double                                    ┃
//    ┃ + millis() : long                                                     ┃
//    ┃ + min(x:double, y:double) : double                                    ┃
//    ┃ + mouseX() : int                                                      ┃
//    ┃ + mouseY() : int                                                      ┃
//    ┃ + mult(a:double, b:double, x:double, y:double) : Complex              ┃
//    ┃ + mult(X:Complex, Y:Complex) : Complex                                ┃
//    ┃ + OpenWebsite(URL:String) : void                                      ┃
//    ┃ + pow(a:double, b:double, x:double, y:double) : Complex               ┃
//    ┃ + pow(X:Complex, Y:Complex) : Complex                                 ┃
//    ┃ + print(message:BigDecimal) : void                                    ┃
//    ┃ + print(message:boolean) : void                                       ┃
//    ┃ + print(message:char) : void                                          ┃
//    ┃ + print(message:double) : void                                        ┃
//    ┃ + print(message:long) : void                                          ┃
//    ┃ + print(message:String) : void                                        ┃
//    ┃ + println() : void                                                    ┃
//    ┃ + println(message:BigDecimal) : void                                  ┃
//    ┃ + println(message:boolean) : void                                     ┃
//    ┃ + println(message:char) : void                                        ┃
//    ┃ + println(message:double) : void                                      ┃
//    ┃ + println(message:long) : void                                        ┃
//    ┃ + println(message:String) : void                                      ┃
//    ┃ + random(x:double) : double                                           ┃
//    ┃ + randomInt(x:double) : int                                           ┃
//    ┃ + re(real:double) : Complex                                           ┃
//    ┃ + re(x:Complex) : double                                              ┃
//    ┃ + ReadFile(FilePathNamethrows:String) : String                        ┃
//    ┃ + real(real:double) : Complex                                         ┃
//    ┃ + real(x:Complex) : double                                            ┃
//    ┃ + round(x:double) : long                                              ┃
//    ┃ + scan() : String                                                     ┃
//    ┃ + scan(Message:String) : String                                       ┃
//    ┃ + sec(x:double) : double                                              ┃
//    ┃ + sech(x:double) : double                                             ┃
//    ┃ + seconds() : double                                                  ┃
//    ┃ + sign(x:double) : double                                             ┃
//    ┃ + sign(x:float) : float                                               ┃
//    ┃ + sin(x:double) : double                                              ┃
//    ┃ + sinh(x:double) : double                                             ┃
//    ┃ + sqrt(X:Complex) : Complex                                           ┃
//    ┃ + sqrt(x:double) : double                                             ┃
//    ┃ + stdDev_population() : double                                        ┃
//    ┃ + stdDev_population() : double                                        ┃
//    ┃ + stdDev_population_ofMean() : double                                 ┃
//    ┃ + stdDev_population_ofMean() : double                                 ┃
//    ┃ + StringDialog() : String                                             ┃
//    ┃ + StringDialog(message:String) : String                               ┃
//    ┃ + StringFromClipboard() : String                                      ┃
//    ┃ + StringScan() : String                                               ┃
//    ┃ + StringToClipboard(myStringToCopy:Object) : void                     ┃
//    ┃ + sub(a:double, b:double, x:double, y:double) : Complex               ┃
//    ┃ + sub(X:Complex, Y:Complex) : Complex                                 ┃
//    ┃ + sum() : double                                                      ┃
//    ┃ + sum() : int                                                         ┃
//    ┃ + tan(x:double) : double                                              ┃
//    ┃ + tanh(x:double) : double                                             ┃
//    ┃ + WriteFile(FilePathName:String, Contentsthrows:String) : void        ┃
//    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
//endregion
@SuppressWarnings({"WeakerAccess","unused","Duplicates","SuspiciousNameCombination"})
class r
{
    //region Console Outputs: print() and println() methods:
    public static void println()
    {
        System.out.print("\n");
    }
    public static void println(String message)
    {
        System.out.println(message);
    }
    public static void print(String message)
    {
        System.out.print(message);
    }
    public static void print(char message)
    {
        System.out.print(message);
    }
    public static void println(char message)
    {
        System.out.println(message);
    }
    public static void println(long message)
    {
        System.out.println(""+message);
    }
    public static void print(long message)
    {
        System.out.print(""+message);
    }
    public static void println(double message)
    {
        System.out.println(""+message);
    }
    public static void print(double message)
    {
        System.out.print(""+message);
    }
    public static void println(boolean message)
    {
        System.out.println(""+message);
    }
    public static void print(boolean message)
    {
        System.out.print(""+message);
    }
    //Special: Can be expanded as I learn new classes
    public static void println(BigDecimal message)
    {
        System.out.println(message.toPlainString());
    }
    public static void print(BigDecimal message)
    {
        System.out.print(message.toPlainString());
    }
    public static void print(Object... message)
    {
        print(Arrays.toString(message));
    }
    public static void println(Object... message)
    {
        print(message);
        println();
    }
    //END FOLD
    //endregion
    //region Console Inputs: {int,long,float,double,boolean,String}Scan() methods:
    public static int intScan()
    {
        return new Scanner(System.in).nextInt();
    }
    public static long longScan()
    {
        return new Scanner(System.in).nextLong();
    }
    public static float floatScan()
    {
        return new Scanner(System.in).nextFloat();
    }
    public static double doubleScan()
    {
        return new Scanner(System.in).nextDouble();
    }
    public static boolean booleanScan()
    {
        return new Scanner(System.in).nextBoolean();
    }
    public static String StringScan()
    {
        return new Scanner(System.in).nextLine();
    }
    public static String scan()
    {
        return new Scanner(System.in).nextLine();
    }
    public static String scan(String Message)
    {
        print(Message);
        return new Scanner(System.in).nextLine();
    }
    public static String StringDialog(String message)
    {
        return javax.swing.JOptionPane.showInputDialog(message);
    }
    public static String StringDialog()
    {
        return javax.swing.JOptionPane.showInputDialog("");
    }
    //endregion END FOLD
    //region Timing Methods: millis(), seconds(), delay(time), tic(),toc(),toc:
    public static long millis()
    {
        return System.currentTimeMillis();
    }
    public static double seconds()
    {
        return System.currentTimeMillis()/1000d;
    }
    public static void delayInMillis(long delayDurationInMilliseconds)
    {
        //region Old version that always kills my laptop's battery!
//        long startTime=System.currentTimeMillis();
//        //noinspection StatementWithEmptyBody
//        while(System.currentTimeMillis()-delayDurationInMilliseconds-startTime<0);
        //endregion
        try
        {
            Thread.sleep(delayDurationInMilliseconds);
        }
        catch(Exception ignored)
        {
        }
    }
    public static void delay(double delayDurationInSeconds)
    {
        //region Old version that always kills my laptop's battery!
//        long startTime=System.currentTimeMillis();
//        //noinspection StatementWithEmptyBody
//        while(System.currentTimeMillis()-delayDurationInSeconds*1000-startTime<0);
        //endregion
        try
        {
            Thread.sleep((long)(delayDurationInSeconds*1000));
        }
        catch(Exception ignored)
        {
        }
    }
    //region Tic and Toc
    private static double toc_start=seconds();
    public static void tic()
    {
        toc_start=seconds();
    }
    public static double toc()
    {
        return toc_start-seconds();
    }
    public static double ptoc()
    {
        double out=toc();
        System.out.println("r.toc() ﹦ "+out);
        return out;
    }
    //endregion
    //END FOLD
    //endregion
    //region Array Math:
    public static int[] range(int Start_Inclusive,int Finish_Exclusive)
    {
        //Works for both forward-sequences, like 12345, and reverse-sequences like 98765.
        //Also works for negative numbers like -1,-2,-3 etc (in both directions of course)
        reverse(new Integer[]{1,2});
        //Generates an integer range like in Python or Matlab
        if(Start_Inclusive<Finish_Exclusive)
        {
            return java.util.stream.IntStream.range(Start_Inclusive,Finish_Exclusive).toArray();
        }
        else if(Start_Inclusive>Finish_Exclusive)
        {
            return toint(reverse(toInteger(range(Finish_Exclusive+1,Start_Inclusive+1))));
        }
        // ∴ else ⋂ Start_Inclusive == Finish_Exclusive ∴ (output is empty int[] array)
        return new int[0];
    }
    public static int[] rangeClosed(int Start_Inclusive,int Finish_Exclusive)
    {
        //Works for both forward-sequences, like 12345, and reverse-sequences like 98765.
        //Also works for negative numbers like -1,-2,-3 etc (in both directions of course)
        reverse(new Integer[]{1,2});
        //Generates an integer range like in Python or Matlab
        if(Start_Inclusive<Finish_Exclusive)
        {
            return java.util.stream.IntStream.rangeClosed(Start_Inclusive,Finish_Exclusive).toArray();
        }
        else if(Start_Inclusive>Finish_Exclusive)
        {
            return toint(reverse(toInteger(rangeClosed(Finish_Exclusive,Start_Inclusive))));
        }
        // ∴ else ⋂ Start_Inclusive == Finish_Exclusive ∴ (output is empty int[] array)
        return new int[]{Start_Inclusive};//====return new int[]{Finish_Inclusive};
    }
    public static Integer[] toInteger(int[] x)
    {
        //Converts an int[] array to an Integer[] array
        Integer[] out=new Integer[x.length];
        int i=0;
        for(int y : x)
        {
            out[i++]=y;
        }
        return out;
    }
    public static int[] toint(Integer[] x)
    {
        //Converts an Integer[] array to an int[] array
        int[] out=new int[x.length];
        int i=0;
        for(Integer y : x)
        {
            out[i++]=y;
        }
        return out;
    }
    public static <T> T[] reverse(T[] array)
    {
        //Using generics to reverse an array without the need for casting
        T[] copy=array.clone();
        Collections.reverse(Arrays.asList(copy));
        return copy;
    }
    public static double[] doubleArray(int... x)
    {
        double[] out=new double[x.length];
        for(int i=0;i<x.length;i++)
        {
            out[i]=x[i];
        }
        return out;
    }
    //endregion
    //region All Real-Number Double Mathematics:
    //Math Constants:
    public static final double PI=3.1415926535897932384626433832795028841971693993751058209749;
    public static final double E=2.7182818284590452353602875;
    public static final double TWO_PI=2*PI;
    public static final double RAD_TO_DEG=360/TWO_PI;
    public static final double DEG_TO_RAD=TWO_PI/360;
    public static final double RAD_PER_DEG=RAD_TO_DEG;//<- Reworded just for clarification
    public static final double DEG_PER_RAD=DEG_TO_RAD;//<- Reworded just for clarification
    //END FOLD
    //Standard Misc Math:
    public static double sum(double... x)
    {
        double out=0;
        for(double y : x)
        {
            out+=y;
        }
        return out;
    }
    public static int sum(int... x)
    {
        int out=0;
        for(int y : x)
        {
            out+=y;
        }
        return out;
    }
    public static double avg(double... x)
    {
        return sum(x)/x.length;
    }
    public static double avg(int... x)
    {
        return avg(doubleArray(x));
    }
    public static double stdDev_population(double... x)
    {
        double avg=avg(x);
        for(int i=0;i<x.length;i++)
        {
            x[i]-=avg;
            x[i]*=x[i];
        }
        return sqrt(sum(x)/(x.length));
    }
    public static double stdDev_population(int... x)
    {
        return stdDev_population(doubleArray(x));
    }
    public static double stdDev_population_ofMean(double... x)
    {
        return stdDev_population(x)/sqrt(x.length);
    }
    public static double stdDev_population_ofMean(int... x)
    {
        return stdDev_population(x)/sqrt(x.length);
    }
    public static double sign(double x)
    {
        return java.lang.Math.signum(x);
    }
    public static float sign(float x)
    {
        return java.lang.Math.signum(x);
    }
    public static double abs(double x)
    {
        return java.lang.Math.abs(x);
    }
    public static double max(double x,double y)
    {
        return java.lang.Math.max(x,y);
    }
    public static double min(double x,double y)
    {
        return java.lang.Math.min(x,y);
    }
    public static long round(double x)
    {
        return java.lang.Math.round(x);
    }
    public static long ceil(double x)
    {
        return (long)java.lang.Math.ceil(x);
    }
    public static long floor(double x)
    {
        return (long)java.lang.Math.floor(x);
    }
    public static double mag(double x,double y)
    {
        return java.lang.Math.hypot(x,y);
    }
    public static double sqrt(double x)
    {
        return java.lang.Math.sqrt(x);
    }
    public static double random(double x)
    {
        return java.lang.Math.random()*x;
    }
    public static int randomInt(double x)
    {
        return (int)(java.lang.Math.random()*x);
    }
    public static boolean chance(double Probability)
    {
        //0<Probability<1
        return random(1)<Probability;
    }
    public static long factorial(long x)
    {
        if(x<0)
        {
            //Cannot take the factorial of a negative integer! Exit the script and return an error message on the console...
            println("ERROR: long factorial(long x) : x="+x+" and x<0 : Cannot take the factorial of a negative integer!");
            System.exit(0);
        }
        int y=1;
        for(int i=1;i<=x;i++)
        {
            y*=i;
        }
        return y;
    }
    //END FOLD
    //Specialized Math Methods:
    public static double angleOf(double x,double y)
    {
        //double AngleOf: Returns the angle between the x-axis and a 2D coordinate in radians. Accepts any coordinate pair except (0,0).
        //Note: This function can be optimized by using arctan() instead of arcsin() and arccos(). I'm too lazy to bother with that today.
        double Magnitude=sqrt(x*x+y*y);
        x/=Magnitude;
        y/=Magnitude;
        if(y>0)
        {
            return acos(x);
        }
        else if(y<0)
        {
            return TWO_PI-acos(x);
        }
        else //if(y==0) <-- Implied
        {
            if(x>0)
            {
                return 0;
            }
            else if(x<0)
            {
                return PI;
            }
            else //if(x==0)
            {
                //Note: The name of this function is mentioned in the following error readout, so if "AngleOf" changes to something else change the error message too!
                println("Error: the point (0,0) does not have an angle! Returning 0... [double AngleOf(float x,float y)]");
                return 0;
            }
        }
    }
    public static double distance(double X,double Y,double x,double y)
    {
        X-=x;
        Y-=y;
        return sqrt(X*X+Y*Y);
    }
    //END FOLD
    //double exp(x) and ln(x):
    public static double exp(double x)
    {
        return java.lang.Math.exp(x);
    }
    public static double ln(double x)
    {
        return java.lang.Math.log(x);
    }
    //END FOLD
    //double Trig Functions:
    public static double sin(double x)
    {
        return java.lang.Math.sin(x);
    }
    public static double cos(double x)
    {
        return java.lang.Math.cos(x);
    }
    public static double tan(double x)
    {
        return java.lang.Math.tan(x);
    }
    public static double asin(double x)
    {
        return java.lang.Math.asin(x);
    }
    public static double acos(double x)
    {
        return java.lang.Math.acos(x);
    }
    public static double atan(double x)
    {
        return java.lang.Math.atan(x);
    }
    //Trig Reciprocals:
    public static double csc(double x)
    {
        return 1.0d/java.lang.Math.sin(x);
    }
    public static double sec(double x)
    {
        return 1.0d/java.lang.Math.cos(x);
    }
    public static double cot(double x)
    {
        return 1.0d/java.lang.Math.tan(x);
    }
    public static double acsc(double x)
    {
        return java.lang.Math.asin(1.0d/x);
    }
    public static double asec(double x)
    {
        return java.lang.Math.acos(1.0d/x);
    }
    public static double acot(double x)
    {
        return java.lang.Math.atan(1.0d/x);
    }
    //END FOLD
    //double Hyperbolic Trig Functions:
    public static double sinh(double x)
    {
        return java.lang.Math.sinh(x);
    }
    public static double cosh(double x)
    {
        return java.lang.Math.cosh(x);
    }
    public static double tanh(double x)
    {
        return java.lang.Math.tanh(x);
    }
    public static double asinh(double x)
    {
        return ln(x+sqrt(x*x+1));
    }
    public static double acosh(double x)
    {
        return ln(x+sqrt(x*x-1));
    }
    public static double atanh(double x)
    {
        return .5d*ln((1+x)/(1-x));
    }
    //Reciprocal Hyperbolic Trig Functions:
    public static double csch(double x)
    {
        return 1.0d/java.lang.Math.sinh(x);
    }
    public static double sech(double x)
    {
        return 1.0d/java.lang.Math.cosh(x);
    }
    public static double coth(double x)
    {
        return 1.0d/java.lang.Math.tanh(x);
    }
    public static double acsch(double x)
    {
        return asinh(1.0d/x);
    }
    public static double asech(double x)
    {
        return acosh(1.0d/x);
    }
    public static double acoth(double x)
    {
        return atanh(1.0d/x);
    }
    //END FOLD
    //endregion
    //region String Conversions:
    public static double Double(String Input)
    {
        return (new BigDecimal(Input)).doubleValue();
    }
    public static double Long(String Input)
    {
        return (new BigDecimal(Input)).longValue();
    }
    public static double Int(String Input)
    {
        return (new BigDecimal(Input)).intValue();
    }
    //endregionß
    //region Ryan's Complex Double Math Methods:
    public class Complex
    {
        public double real, imag;
        Complex(double RealIn,double ImaginaryIn)
        {
            real=RealIn;
            imag=ImaginaryIn;
        }
        double re()
        {
            return real;
        }
        double real()
        {
            return real;
        }
        double im()
        {
            return imag;
        }
        double imag()
        {
            return imag;
        }
        double abs()
        {
            return imag*imag+real*real;
        }
        double arg()
        {
            return r.angleOf(real,imag);
        }
        //Non-Math Methods:
        void PrintLn()
        {
            r.print(real);
            if(imag>=0)
            {
                r.print(" + ");
                r.print(imag);
            }
            else
            {
                r.print(" - ");
                r.print(""+(-imag));
            }
            r.println("i");
        }
    }
    double re(Complex x)
    {
        return x.re();
    }
    double real(Complex x)
    {
        return x.re();
    }
    double im(Complex x)
    {
        return x.im();
    }
    double imag(Complex x)
    {
        return x.im();
    }
    double abs(Complex x)
    {
        return x.abs();
    }
    double arg(Complex x)
    {
        return x.arg();
    }
    Complex complex(double real,double imag)//The lower-case "complex" is so we can write equations in single lines, rather than having to declare "blah.... = new Complex()" each time we want to perform a complex arithmetic operation.
    {
        return new Complex(real,imag);
    }
    Complex real(double real)//Returns a real number in the form of the Complex class, that has an imaginary component of zero and a real component of "real".
    {
        return new Complex(real,0);
    }
    Complex re(double real)//Returns a real number in the form of the Complex class, that has an imaginary component of zero and a real component of "real".
    {
        return new Complex(real,0);
    }
    Complex imag(double imag)//Returns a purely imaginary number in the form of the Complex class, that has an imaginary component of "imag" and a real component of 0.
    {
        return new Complex(0,imag);
    }
    Complex im(double imag)//Returns a purely imaginary number in the form of the Complex class, that has an imaginary component of "imag" and a real component of 0.
    {
        return new Complex(0,imag);
    }
    //Bivariate Complex Functions:
    Complex mult(Complex X,Complex Y)
    {
        double a=X.re();
        double b=X.im();
        double x=Y.re();
        double y=Y.im();
        return new Complex(a*x-b*y,a*y+b*x);
    }
    Complex mult(double a,double b,double x,double y)
    {
        //Returns a Complex number, (a+bi)*(x+yi), where a, b, x and y are all real numbers.
        return new Complex(a*x-b*y,a*y+b*x);
    }
    Complex div(Complex X,Complex Y)
    {
        double a=X.re();
        double b=X.im();
        double x=Y.re();
        double y=Y.im();
        double imagOut=(b*x-a*y)/(x*x+y*y);
        double realOut=(a*x+b*y)/(x*x+y*y);
        return new Complex(realOut,imagOut);
    }
    Complex div(double a,double b,double x,double y)
    {
        //Returns a Complex number, (a+bi)/(x+yi), where a, b, x and y are all real numbers.
        double imagOut=(b*x-a*y)/(x*x+y*y);
        double realOut=(a*x+b*y)/(x*x+y*y);
        return new Complex(realOut,imagOut);
    }
    Complex add(Complex X,Complex Y)
    {
        double a=X.re();
        double b=X.im();
        double x=Y.re();
        double y=Y.im();
        return new Complex(a+x,b+y);
    }
    Complex add(double a,double b,double x,double y)
    {
        //Returns a Complex number, (a+bi)+(x+yi), where a, b, x and y are all real numbers.
        return new Complex(a+x,b+y);
    }
    Complex sub(Complex X,Complex Y)
    {
        double a=X.re();
        double b=X.im();
        double x=Y.re();
        double y=Y.im();
        return new Complex(a-x,b-y);
    }
    Complex sub(double a,double b,double x,double y)
    {
        //Returns a Complex number, (a+bi)-(x+yi), where a, b, x and y are all real numbers.
        return new Complex(a-x,b-y);
    }
    //Univariate Complex Functions:
    Complex exp(Complex X)
    {
        double a=X.re();
        double b=X.im();
        double realOut=exp(a)*cos(b);
        double imagOut=exp(a)*sin(b);
        return new Complex(realOut,imagOut);
    }
    Complex exp(double a,double b)
    {
        //Returns a Complex number, exp(a+bi), where a and b are both real numbers.
        double realOut=exp(a)*cos(b);
        double imagOut=exp(a)*sin(b);
        return new Complex(realOut,imagOut);
    }
    Complex ln(Complex X)
    {
        double a=X.re();
        double b=X.im();
        double realOut=.5*ln(a*a+b*b);
        double imagOut=X.arg();
        return new Complex(realOut,imagOut);
    }
    Complex ln(double a,double b)
    {
        //Returns a Complex number, ln(a+bi), where a and b are both real numbers.
        double realOut=.5*ln(a*a+b*b);
        double imagOut=angleOf(a,b);
        return new Complex(realOut,imagOut);
    }
    //Higher-order complex functions...
    Complex pow(Complex X,Complex Y)
    {
        //Returns a Complex number, X^Y, where X and Y can both be complex numbers.
        return exp(mult(Y,ln(X)));
    }
    Complex pow(double a,double b,double x,double y)
    {
        //Returns a Complex number, (a+bi)^(x+yi), where a, b, x and y are all real numbers.
        return exp(mult(complex(x,y),ln(complex(a,b))));
    }
    Complex log(Complex Base,Complex X)//!!!Warning: Syntax order is arbitrary!!! Pay attention: It's log_(Base) of X.
    {
        //Returns a Complex number, the log of X in base Base, where X and Y can both be complex numbers.
        return div(ln(X),ln(Base));
    }
    Complex log(double Base_a,double Base_b,double X_x,double X_y)//!!!Warning: Syntax order is arbitrary!!! Pay attention: It's log_(Base) of X.
    {
        //Returns a Complex number, the log of X in base Base, where X and Y can both be complex numbers. X and Y are constructed from the four input-doubles.
        return log(complex(Base_a,Base_b),complex(X_x,X_y));
    }
    Complex sqrt(Complex X)
    {
        //Returns a Complex number, sqrt(X), where X is a Complex number.
        return pow(X,re(.5));
    }
    boolean Boolean(int x)
    {
        return x>=1;
    }
    int Int(boolean x)
    {
        if(x)
        {
            return 1;
        }
        return 0;
    }
    //END FOLD
    //endregion
    //region Mouse Information:
    public static int mouseX()
    {
        return MouseInfo.getPointerInfo().getLocation().x;
    }
    public static int mouseY()
    {
        return MouseInfo.getPointerInfo().getLocation().y;
    }
    //END FOLD
    //endregion
    //region Clipboard:
    public static void StringToClipboard(Object myStringToCopy)
    {
        java.awt.Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new java.awt.datatransfer.StringSelection(myStringToCopy.toString()),null);
    }
    public static String StringFromClipboard()
    {
        try
        {
            return (String)java.awt.Toolkit.getDefaultToolkit().getSystemClipboard().getData(java.awt.datatransfer.DataFlavor.stringFlavor);
        }
        catch(Exception a)
        {
            System.out.println("I honestly don't give a crap about catching this exception but it makes me put one here anyway.");
            return "ERROR4622888886666666666";
        }
    }
    //endregion
    //region Web:
    public static void OpenWebsite(String URL)
    {
        try
        {
            java.awt.Desktop.getDesktop().browse(new java.net.URI(URL));
        }
        catch(Exception x)
        {
            println("ERROR: Exception thrown: r.OpenWebsite("+URL+"); : "+x.getMessage()+" : "+x.toString());
        }
    }
    //endregion
    //region Read/Write to/from Text Files:
    public static String ReadFile(String FilePathName) throws java.io.FileNotFoundException
    {
        java.util.Scanner Input=new java.util.Scanner(new java.io.File(FilePathName));
        if(!Input.hasNextLine())
        {
            return "";
        }
        String Output=Input.nextLine();
        while(Input.hasNextLine())
        {
            Output+="\n"+Input.nextLine();
        }
        Input.close();
        return Output;
    }
    public static void WriteFile(String FilePathName,String Contents) throws java.io.IOException
    {
        java.io.PrintWriter Writer=new java.io.PrintWriter(FilePathName);
        Writer.print(Contents);
        Writer.close();
    }
    //endregion
    //region Screen Width/Height (In Pixels) (AKA The resolution):
    public static final int screenWidth=(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    public static final int screenHeight=(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    public static int ScreenWidth()
    {
        //NOTE: In order to get the maximum pixel in a dimension, you must subtract 1 from this!
        //(When trying to detect if mouse is in corner of screen for example)
        return screenWidth;
    }
    public static int ScreenHeight()
    {
        //NOTE: In order to get the maximum pixel in a dimension, you must subtract 1 from this!
        //(When trying to detect if mouse is in corner of screen for example)
        return screenHeight;
    }
    //endregion
}
@SuppressWarnings({"Duplicates","WeakerAccess"})
class OLDparenthesisScrapNewAlgorithmTest extends MakeParenthesis_drudgeon
{
    public static void printintarray(int[] Levels)
    {
        String out="";
        for(int x : Levels)
        {
            out+=x;
        }
        System.out.println(out);
    }
    public static void printintarraywithspaces(int[] Levels)
    {
        String out="";
        for(int x : Levels)
        {
            out+=x+" ";
        }
        System.out.println(out);
    }
    public static int nextCharIndex(String x,char c,int initialindex)
    {
        try
        {
            return x.indexOf(c,initialindex+1);
        }
        //region junk
        catch(Exception ignoredb)
        {
            try
            {
                Audio.waa();
            }
            catch(Exception ignored)
            {
            }
            System.out.println("MADE SOME SORTA ERROR HERE!!! IT's an internal logic problem, not due to external noise. Remove me if I never show up during testing.");
            return initialindex;
        }
        //endregion
    }
    public static boolean seesGoodCharacterBeforeAnyOfTheseBadCharacters(String context,int index,char good,char... bad)
    {
        return goodCharacterIsToLeftOfAllBadCharacters(context.substring(index+1,context.length()),good,bad);
    }
    public static boolean goodCharacterIsToLeftOfAllBadCharacters(String context,char good,char... bad)
    {
        for(char c : context.toCharArray())
        {
            if(c==good)
            {
                return true;
            }
            else if(isAnElementOf(c,bad))
            {
                return false;
            }
        }
        //We have reached this point ⟹ that 'context' contains no good or bad characters, I.E. ...
        // ...  ∴ ∀ char ∈ context, char ∉ good ⋃ bad
        return false;//The default response in this scenario
    }
    public static int[] append(int[] a,int... b)
    {
        int[] out=new int[a.length+b.length];
        System.arraycopy(a,0,out,0,a.length);
        System.arraycopy(b,0,out,a.length,b.length);
        return out;
    }
    public static int[][] append(int[][] a,int[]... b)
    {
        int[][] out=new int[a.length+b.length][];
        System.arraycopy(a,0,out,0,a.length);
        System.arraycopy(b,0,out,a.length,b.length);
        return out;
    }
    public static boolean isAnElementOf(int a,int... b)
    {
        //returns a ∈ b
        for(int c : b)
        {
            if(a==c)
            {
                return true;
            }
        }
        return false;
    }
    public static boolean isAnElementOf(char a,char... b)
    {
        //returns a ∈ b
        for(char c : b)
        {
            if(a==c)
            {
                return true;
            }
        }
        return false;
    }
    public static int[] GenerateParenthesisLevels(String input)
    {
        String originalinput=input;
        int[][] AllLevels=new int[0][0];
        char empty='◌';
        System.out.println(originalinput);
        if(UniversalVariables.IgnoreDoubles)
        {
            originalinput=UML_Generator_Curvy.ExecuteRules(input,2,UML_Generator_Curvy.Rule(x->x.equals("()")||x.equals("{}")||x.equals("[]"),y->"⨀⨀"));
            input=originalinput;
        }
        System.out.println("ORIGINALINPUT START:\n"+originalinput+"ORIGINALINPUT END");
        //ONLY GENERALIZED FOR () RIGHT NOW
        //FOR LOOP:
        char[] BadCharacters=new char[]{'(','[','{'};
        char[] GoodCharacters=new char[]{')',']','}'};
        while(true)
        {
            int[] ThisLevel=new int[0];
            int index=0;
            for(char c : input.toCharArray())
            {
                if(isAnElementOf(c,BadCharacters))
                {
                    char conjugate=c=='('?')':c=='['?']':'}';
                    if(seesGoodCharacterBeforeAnyOfTheseBadCharacters(input,index,conjugate,BadCharacters))
                    {
                        ThisLevel=append(ThisLevel,index,nextCharIndex(input,conjugate,index));
                    }
                }
                index++;
            }
            //And now to fill each of the chars in the string with the empties:
            String newinput="";
            int i=0;
            for(char c : input.toCharArray())
            {
                if(isAnElementOf(i,ThisLevel))
                {
                    newinput+=empty;
                }
                else
                {
                    newinput+=c;
                }
                i++;
            }
            assert (ThisLevel.length==0)==(input.equals(newinput));//an internal logic assertion. not a input-noise one.
            if(ThisLevel.length==0)
            {
                break;
            }
            input=newinput;
            AllLevels=append(AllLevels,ThisLevel);
            //The next two lines of code are purely for visualization purposes to see if this algorithm produced what I had drawn on paper.
            //PLEASE DO NOT DELETE! JUST COMMENT OR UNCOMMENT THEM.
            printintarraywithspaces(ThisLevel);
            System.out.println(newinput);
        }
        //Now that we have our level diagram, we can construct the level
        int[] output=new int[input.length()];
        int levelnumber=1;
        for(int[] level : AllLevels)
        {
            for(int associatedcharcolumn : level)
            {
                output[associatedcharcolumn]=levelnumber;
            }
            levelnumber++;
        }
        System.out.println("");
        System.out.println("FINAL OUTPUT:");
        printintarray(output);
        System.out.println(originalinput);
        //THIS CODE IS NOW CAPABLE OF HANDLING MORE THAN JUST ()'s.
        //HERE'S THE CHEAP AND DIRTY CONVERSION CODE TO MAKE IT COMPATIBLE WITH THE PREVIOUS VERSION:
        //region cheapn'dirty
        int i=0;
        for(char c : originalinput.toCharArray())
        {
            if(UniversalVariables.HideLevel1)
            {
//                System.out.println("PARTY TIME!!\nPARTY TIME!!\nPARTY TIME!!\nPARTY TIME!!\n");
                output[i]--;//Show innermost parenthesis by turning all 0's into 1's etc
            }
            if(output[i]<0)
            {
                output[i]=0;
            }
            if(isAnElementOf(c,GoodCharacters))
            {
                output[i]*=-1;
            }
            i++;
        }
        //endregion
        return output;
    }
    public static void main(String[] args)
    {
        String input="(((a))+(b))";
        GenerateParenthesisLevels(input);
    }
}
//        System.out.println(Arrays.toString(append(new int[]{1,2,3},4,5,6)));
//
//        System.out.println(seesGoodCharacterBeforeAnyOfTheseBadCharacters("...(...)",3,')','('));
//        System.out.println(seesGoodCharacterBeforeAnyOfTheseBadCharacters("...(..(.)",4,')','('));
//        System.out.println(seesGoodCharacterBeforeAnyOfTheseBadCharacters("...(..(.)",4,')','(','['));
//region scrapped
//        String input="...(...(...(...)...)...(...)...)...";
//        int[]Levels=new int[input.length()];
//        int i=0;
//        for(char c:input.toCharArray())
//        {
//            int a=nextCharIndex(input,'(',i);
//            int b=nextCharIndex(input,')',i);
//            if(a<b)
//            {
//                Levels[a]=++Levels[b];
//            }
//            i++;
//        }
//        printintarray(Levels);
//endregion
//region Scrapped
//    public static void printintarray(int[] Levels)
//    {
//        String out="";
//        for(int x : Levels)
//        {
//            out+=x;
//        }
//        System.out.println(out);
//    }
//    public static void main(String[] args)
//    {
//        String input="((())())";
//
//        //region Parenthesis Counter -> int[]Levels
//        char[]inputarray=input.toCharArray();
//        int Level=0,MaxLevelMagnitude=0,i=0,length=input.length();
//        int[] Levels=new int[length];
//        for(char c : inputarray)
//        {
//            //region (Expanded version of next line)
//            //            if(c=='(')
//            //            {
//            //                Levels[i++]=++Level;
//            //            }
//            //            else if(c==')')
//            //            {
//            //                Levels[i++]=Level--;
//            //            }
//            //            else
//            //            {
//            //                Levels[i++]=0;
//            //            }
//            //endregion
//region a
//            Levels[i++]=c=='('?++Level:c==')'?Level--:0;
//            MaxLevelMagnitude=Math.max(MaxLevelMagnitude,Math.abs(Level));
//        }
//        //endregion
//        //programming forces you to only look at the small picture........
//        //........I don't want to become a programmer..........though, it IS rather zen-like; meditative even......
//
//        System.out.println(input);
//        printintarray(Levels);
//        System.out.println(MaxLevelMagnitude);
//
//        for(i=0;i<length-1;i++)
//        {
//            if(inputarray[i]=='('&&Levels[i]==Levels[i+1])
//            {
//                Levels[i]=Levels[i+1]=0;
//            }
//        }
//        printintarray(Levels);
//
//endregion
//Copyright Ryan Burgert 2016. But distribute or whatever stuff you want legals.
//Anyway, this code basically helps to summarize a .java file you might write into its simplest components: all the declarations of variables and methods and classes etc without their values.
//To see what I mean, copy this whole code into your clipboard. Then run the code. Then type "asdf" or whatever you want into the console. Then press enter. Then paste this code into the console. Then press Enter. Then type "asdf" again. Then press enter.
//Then you'll see what this code does. Pretty neat, huh? It can be used to quickly generate UML diagrams!
@SuppressWarnings("Duplicates")
class UML_Generator_Curvy extends r
{
    //region User Inputs:
    final static boolean UML_DisplayVariableType=true;//UserInput++
    final static boolean UML_DisplayMethodType=true;//UserInput++
    final static boolean UML_DisplayMethodParameterType=true;//UserInput++
    final static boolean UML_DisplayMethodParameterNames=true;//UserInput++
    final static String UML_VariableNamePrefix=" - ";//UserInput++
    final static String UML_MethodNamePrefix=" + ";//UserInput++
    final static String UML_RegularSeparator=" : ";//UserInput++
    final static String UML_MethodParameterSeparator=":";//UserInput++
    final static String UML_MethodParameterCommaStyle=", ";//UserInput++
    final static boolean UML_CurvyBorders=false;
    //endregion User Inputs
    static public String ConsoleInput()
    {
        println("af");
        Scanner khihiu=new Scanner(System.in);
        System.out.println(" - Enter a random word here: ");
        String EscapeSequence=khihiu.nextLine();
        System.out.println(" - Enter your code and then re-enter your random word: ");
        String Input="", x;
        do
        {
            Input+="\n"+(x=khihiu.nextLine());
        }
        while(!x.equals(EscapeSequence));
        return ReplaceFirst(Input,EscapeSequence,"").trim();
    }
    public static String StringFromClipboard()
    {
        try
        {
            System.out.println(" - Input from clipboard received! Please wait...");
            return (String)java.awt.Toolkit.getDefaultToolkit().getSystemClipboard().getData(java.awt.datatransfer.DataFlavor.stringFlavor);
        }
        catch(Exception a)
        {
            return ConsoleInput();//"ERROR: Nothing copied to the clipboard! Please do that then try again.";
        }
    }
    public static void StringToClipboard(Object myString)
    {
        java.awt.Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new java.awt.datatransfer.StringSelection(myString.toString()),null);
    }
    static String ReplaceFirst(String Original,String OldSnippet,String NewSnippet)
    {
        //I had to create this method because REGEX sucks and breaks my code each time I use a "{" or "}".
        for(int i=0;i<=Original.length()-OldSnippet.length();i++)
        {
            if(Original.substring(i,i+OldSnippet.length()).equals(OldSnippet))
            {
                return Original.substring(0,i)+NewSnippet+Original.substring(i+OldSnippet.length(),Original.length());
            }
        }
        return Original;
    }
    interface rStringToString
    {
        String f(String x);
    }
    interface rStringToBoolean
    {
        boolean f(String x);
    }
    public static class ConditionalReplacement
    {
        //This compact little nugget lets us list it indefinitely in String ReplacementRules. This is another way to say "rule". "Conditional Replacement" == "Rule"
        public rStringToBoolean Condition;
        public rStringToString Replacement;
        ConditionalReplacement(rStringToBoolean Condition,rStringToString Replacement)
        {
            this.Condition=Condition;
            this.Replacement=Replacement;
        }
    }
    public static ConditionalReplacement Rule(rStringToBoolean Condition,rStringToString Replacement)
    {
        //Syntactic sugar.
        return new ConditionalReplacement(Condition,Replacement);
    }
    public static String ExecuteRules(String x,int SnippetLength,ConditionalReplacement... rules)
    {
        //This method was originally coded recursively, but that didn't end well: it often committed suicide over stack overflow error. The recursive form of this method has 6 less lines.
        String Snippet;
        for(boolean KeepGoing=true;KeepGoing;)
        {
            KeepGoing=false;
            B:
            for(int i=0;i<=x.length()-SnippetLength;i++)//go through x with snippet
            {
                for(ConditionalReplacement rule : rules)//check all rules for each snippet
                {
                    if(rule.Condition.f(Snippet=x.substring(i,i+SnippetLength)))
                    {//if rule satisfied
                        x=ReplaceFirst(x,Snippet,rule.Replacement.f(Snippet));//redo x
                        KeepGoing=true;
                        break B;
                    }
                }
            }
        }//Stop making replacements! start from beginning. This simulates recursion.
        return x;
    }//We have made no replacements in this version of x.
    final static String UML_VariableToMethodPartition="↻❂↺";//Random characters that cannot be used in the actual code input in that order. Probability seems pretty low though.
    final static String UML_Title="";//UserInput++
    public static void main(String[] StringArray)
    {
        System.out.println("Ryan Burgert's UML Generator Mark 1.0");
        //This code works by creating a whole bunch of micro-rules that look at no more than 3 characters at a time. Using these rules, we summarize the whole code.
        //String OriginalInput=ConsoleInput();
        String OriginalInput=StringFromClipboard();
        String Input=OriginalInput.substring(OriginalInput.indexOf('{')+1,OriginalInput.lastIndexOf('}'));//This line allows us to copy and paste in the whole class
        //String Input=Input.replaceFirst("\\{","");//For the first opening bracket in the code in the class declaration.
        Input=ExecuteRules(Input,3,Rule(x->x.substring(0,2).equals("//")&&x.charAt(2)!='\n',y->"//"));
        Input=ExecuteRules(Input,2,Rule(x->x.equals("//"),y->""));
        Input=ExecuteRules(Input,2,Rule(x->x.equals("/*")||x.equals("*/"),y->"\""));//sloppy but effective if no odd number of  " in comment
        Input=ExecuteRules(Input,2,Rule(x->x.charAt(0)=='"'&&x.charAt(1)!='"',y->"\""),Rule(x->x.equals("\"\""),y->""));
        //println(Input);
        Input=ExecuteRules(Input,2,Rule(x->x.charAt(0)=='\''&&x.charAt(1)!='\'',y->"\'"),Rule(x->x.equals("\'\'"),y->""));
        Input=ExecuteRules(Input,2,Rule(x->x.charAt(1)=='@',y->"@"));
        Input=ExecuteRules(Input,1,Rule(x->x.equals("@"),y->""));
        Input=ExecuteRules(Input,1,Rule(x->x.equals("\n"),y->""));
        Input=ExecuteRules(" "+Input,2,Rule(x->x.equals("  "),y->" ")).substring(1);
        Input=ExecuteRules(Input,2,Rule(x->x.equals(";;")||x.equals("=;"),y->";"));
        Input=ExecuteRules(Input,2,Rule(x->x.equals(",,")||x.equals("=,"),y->","));
        Input=ExecuteRules(Input,2,Rule(x->x.equals("= ")||x.equals(", ")||x.equals("} ")||x.equals("{ ")||x.equals("; "),y->""+y.charAt(0)));
        Input=ExecuteRules(Input,2,Rule(x->x.equals(" =")||x.equals(" ,")||x.equals(" }")||x.equals(" {")||x.equals(" ;"),y->""+y.charAt(1)));
        Input=ExecuteRules(Input,3,Rule(x->Character.isLetterOrDigit/* <--see comment*/(x.charAt(0))&&x.charAt(1)=='='&&x.charAt(2)!=';'&&x.charAt(2)!='{'&&x.charAt(2)!='}'&&x.charAt(2)!=',',y->y.charAt(0)+"="));
        Input=ExecuteRules(Input,3,Rule(x->(x.charAt(0)=='{')&&(x.charAt(1)!='{')&&(x.charAt(1)!='}'),y->"{"+y.charAt(2)),Rule(x->x.equals("{{}"),y->"{"));
        Input=ExecuteRules(Input,2,Rule(x->x.equals("{}"),y->";"));
        Input=ExecuteRules(Input,1,Rule(x->x.equals(";"),y->"\n"),Rule(x->x.equals("="),y->""));
        //We delete all private variables. I'm assuming that these variables do not need to be shown in a UML diagram.
        Input=ExecuteRules(Input,9,Rule(x->x.substring(0,8).equals("private ")&&x.charAt(8)!='\n',y->"private "),Rule(x->x.equals("private \n"),y->""));
        Input=ExecuteRules(Input,8,Rule(x->x.equals("private "),y->""));
        //Input=ExecuteRules(Input,7,Rule(x->x.equals("public ")||x.equals("static "),y->""));
        StringArray=Input.split("\n");
        //System.out.print("\n\n\n======  FINAL (ORIGINAL ORDER)  ======\n\n"+(Input=String.join("\n",StringArray=Input.split("\n"))).substring(0,Input.length()-1));
        //Arrays.sort(StringArray);
        //System.out.print("\n\n\n======  FINAL (SORTED ALPHABETICALLY)  ======\n\n"+(Input=String.join("\n",StringArray)).substring(0,Input.length()-1));
        String Methods="", Variables="";
        for(String S : StringArray)
        {
            if(S.contains("("))
            {
                Methods+=S+"\n";
            }
            else
            {
                Variables+=S+"\n";
            }
        }
        String[] PureVariables=Variables.split("\n");
        String[] PureMethods=Methods.split("\n");
        //System.out.println("\nDebug:\n"+Methods+"\n");
        //System.out.println("\nDebug:\n"+Variables+"\n");
        //Here we re-use StringArray as something else; we're done with it now.
        for(int i=0;i<PureVariables.length;i++)
        {
            PureVariables[i]=UML_VariableNamePrefix+(StringArray=PureVariables[i].split(" "))[(StringArray.length-1)==-1?0:StringArray.length-1]+(UML_DisplayVariableType?UML_RegularSeparator+StringArray[(StringArray.length-2)==-1?0:StringArray.length-2]:"");
        }
        //Next 3 Lines: Sorting PureVariables in alphabetical order; ignoring the case of each letter.
        java.util.List<String> TempList=Arrays.asList(PureVariables);
        Collections.sort(TempList,String.CASE_INSENSITIVE_ORDER);
        TempList.toArray(PureVariables);
        //We're also done with the Strings "Methods" and "Variables". We're going to mess them up now, so don't reference either later on in the previous context!
        Variables=ExecuteRules(String.join("\n",PureMethods),2,Rule(x->x.charAt(0)=='('&&x.charAt(1)!='\n',y->"("));//Basically now Variables is the first portion of "a b c(d,e,f)" -> "a b c"
        Variables=ExecuteRules(Variables,1,Rule(x->x.equals("(")||x.equals(")"),y->""));
        Methods=ExecuteRules(String.join("\n",PureMethods),2,Rule(x->x.charAt(1)=='('&&x.charAt(0)!='\n',y->"("));//And also, now Methods has been changed to: "a b c(d,e,f)" -> "d,e,f"
        Methods=ExecuteRules(Methods,1,Rule(x->x.equals("(")||x.equals(")"),y->""));
        String[] PureMethods_FirstHalf=Variables.split("\n");
        String[] PureMethods_SecondHalf=Methods.split("\n");
        for(int i=0;i<PureMethods_SecondHalf.length;i++)
        {
            if(PureMethods_SecondHalf[i].contains(" "))
            {
                StringArray=PureMethods_SecondHalf[i].split(",");//PureMethods_SecondHalf[i].contains(",")?PureMethods_SecondHalf[i].split(","):new String[]{PureMethods_SecondHalf[i]};
                for(int j=0;j<StringArray.length;j++)
                {
                    String[] Temp=StringArray[j].split(" ");//This must have a length of 2 because we assume the code input would compile properly.
                    try
                    {
                        StringArray[j]=(UML_DisplayMethodParameterNames?Temp[1]:"")+(UML_DisplayMethodParameterType?(UML_DisplayMethodParameterNames?UML_MethodParameterSeparator:"")+Temp[0]:"");
                    }
                    catch(Exception o)
                    {
                    }
                }
                PureMethods_SecondHalf[i]=(UML_DisplayMethodParameterNames||UML_DisplayMethodParameterType)?"("+String.join(",",StringArray)+")":"()";
            }
            else
            {
                PureMethods_SecondHalf[i]="()";
            }
        }
        for(int i=0;i<Math.min(PureMethods_FirstHalf.length,PureMethods_SecondHalf.length);i++)
        {
            PureMethods[i]=PureMethods_FirstHalf[i]+PureMethods_SecondHalf[i];
        }
        for(int i=0;i<PureMethods.length;i++)
        {
            if(PureMethods[i].contains(" "))
            {
                PureMethods[i]=UML_MethodNamePrefix+(StringArray=PureMethods[i].split(" "))[StringArray.length-1]+(UML_DisplayMethodType?UML_RegularSeparator+StringArray[StringArray.length-2]:"");
            }
            else
            {
                PureMethods[i]=UML_MethodNamePrefix+PureMethods[i];
            }
        }
        Arrays.sort(PureMethods);
        //Next 3 Lines: Sorting PureVariables in alphabetical order; ignoring the case of each letter.┨┗┛┓┏┃━┠─
        TempList=Arrays.asList(PureMethods);
        Collections.sort(TempList,String.CASE_INSENSITIVE_ORDER);
        TempList.toArray(PureMethods);
        Input=String.join("\n",PureVariables)+(UML_VariableToMethodPartition.equals("")?"\n":"\n"+UML_VariableToMethodPartition+"\n")+String.join("\n",PureMethods);
        Input=ExecuteRules(Input,1,Rule(x->x.equals(","),y->"⏣"));//We assume the user doesn't have this randomly chosen unicode character ⏣ in their code.
        Input=ExecuteRules(Input,1,Rule(x->x.equals("⏣"),y->UML_MethodParameterCommaStyle)).replaceAll("-  : ","(No Variables)").replaceAll("\\+ \\(\\)","(No Methods)");
        Input=(UML_Title.equals("")?"":"\n")+Input;
        StringArray=Input.split("\n");
        //  Determine the title of the class:
        String Title=OriginalInput.substring(0,OriginalInput.indexOf('{'));
        Title=ExecuteRules(Title,3,Rule(x->x.substring(0,2).equals("//")&&x.charAt(2)!='\n',y->"//"));
        Title=ExecuteRules(Title,2,Rule(x->x.equals("//"),y->""));
        Title=ExecuteRules(Title,2,Rule(x->x.equals("/*")||x.equals("*/"),y->"\""));//sloppy but effective if no odd number of  " in comment
        Title=ExecuteRules(Title,2,Rule(x->x.charAt(0)=='"'&&x.charAt(1)!='"',y->"\""),Rule(x->x.equals("\"\""),y->"")).replaceAll("\n","");
        String[] q=Title.split(" ");
        Title="";//New meaning for Title
        for(int i=q.length-1;i>=0;i--)
        {
            if(q[i].equals("class"))
            {
                Title=q[i+1];
                break;
            }
        }
        Title=" "+Title;//For aesthetic indentation
        //Creating the box around the text:
        int MaxNumberOfCharacters=0;
        for(String a : StringArray)
        {
            MaxNumberOfCharacters=Math.max(a.length(),MaxNumberOfCharacters);
        }
        MaxNumberOfCharacters++;//+1 for a 1 character margin
        for(int i=0;i<StringArray.length;i++)
        {
            while(StringArray[i].length()!=MaxNumberOfCharacters)
            {
                StringArray[i]+=" ";
            }
        }
        for(int i=0;i<StringArray.length;i++)
        {
            StringArray[i]="┃"+StringArray[i]+"┃";
        }
        Input=String.join("\n",StringArray);
        String AddToInputTop="";
        for(int i=0;i<MaxNumberOfCharacters;i++)
        {
            AddToInputTop+="─";
        }
        AddToInputTop="┠"+AddToInputTop+"┨\n";
        Input=AddToInputTop+Input;
        while(Title.length()!=MaxNumberOfCharacters)
        {
            Title+=" ";
        }
        Title="┃"+Title+"┃\n";
        Input=Title+Input;
        //New AddToInputTop:
        AddToInputTop=AddToInputTop.replaceAll("┠","┏").replaceAll("┨","┓").replaceAll("─","━");
        Input=AddToInputTop+Input;
        //System.out.println(Input);
        String AddToInputBottom=AddToInputTop.replaceAll("┏","┗").replaceAll("┓","┛");
        Input=Input+"\n"+AddToInputBottom;
        String TrueDivider=AddToInputTop.replaceAll("┏","┠").replaceAll("┓","┨").replaceAll("\n","").replaceAll("━","┈");
        StringArray=Input.split("\n");
        for(int i=0;i<StringArray.length;i++)
        {
            if(StringArray[i].contains(UML_VariableToMethodPartition))
            {
                StringArray[i]=TrueDivider;
            }
        }
        Input=String.join("\n",StringArray);
        //Final Output:
        if(!UML_CurvyBorders)
        {
            System.out.println(Input.replaceAll("┏","┏").replaceAll("┓","┓").replaceAll("┨","┨").replaceAll("┠","┠").replaceAll("━","━").replaceAll("┃","┃").replaceAll("─","─").replaceAll("┃","┃").replaceAll("┗","┗").replaceAll("┛","┛").replaceAll("┈","┈"));
        }
        else
        {
            System.out.println(Input=Input.replaceAll("┏","╭").replaceAll("┓","╮").replaceAll("┨","┤").replaceAll("┠","├").replaceAll("─","┈").replaceAll("━","─").replaceAll("┃","│").replaceAll("┗","╰").replaceAll("┛","╯").replaceAll("┈","┈"));
        }
        StringToClipboard(Input);
        System.out.println("Output has been copied to your clipboard.");
    }
}
//┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
//┃ UML_Generator                                                                            ┃
//┠──────────────────────────────────────────────────────────────────────────────────────────┨
//┃ - ConditionalReplacement : class                                                         ┃
//┃ - rStringToBoolean : interface                                                           ┃
//┃ - rStringToString : interface                                                            ┃
//┃ - UML_DisplayMethodParameterNames : boolean                                              ┃
//┃ - UML_DisplayMethodParameterType : boolean                                               ┃
//┃ - UML_DisplayMethodType : boolean                                                        ┃
//┃ - UML_DisplayVariableType : boolean                                                      ┃
//┃ - UML_MethodNamePrefix : String                                                          ┃
//┃ - UML_MethodParameterCommaStyle : String                                                 ┃
//┃ - UML_MethodParameterSeparator : String                                                  ┃
//┃ - UML_RegularSeparator : String                                                          ┃
//┃ - UML_Title : String                                                                     ┃
//┃ - UML_VariableNamePrefix : String                                                        ┃
//┃ - UML_VariableToMethodPartition : String                                                 ┃
//┠┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┨
//┃ + ConsoleInput() : String                                                                ┃
//┃ + ExecuteRules(x:String, SnippetLength:int, rules:ConditionalReplacement...) : String    ┃
//┃ + main(StringArray:String[]) : void                                                      ┃
//┃ + ReplaceFirst(Original:String, OldSnippet:String, NewSnippet:String) : String           ┃
//┃ + Rule(Condition:rStringToBoolean, Replacement:rStringToString) : ConditionalReplacement ┃
//┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
/**
 * ╭──────────────────────────────────────────────────────────────────────────────────────────╮
 * │ UML_Generator_Curvy                                                                      │
 * ├┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┤
 * │ - ConditionalReplacement : class                                                         │
 * │ - rStringToBoolean : interface                                                           │
 * │ - rStringToString : interface                                                            │
 * │ - UML_DisplayMethodParameterNames : boolean                                              │
 * │ - UML_DisplayMethodParameterType : boolean                                               │
 * │ - UML_DisplayMethodType : boolean                                                        │
 * │ - UML_DisplayVariableType : boolean                                                      │
 * │ - UML_MethodNamePrefix : String                                                          │
 * │ - UML_MethodParameterCommaStyle : String                                                 │
 * │ - UML_MethodParameterSeparator : String                                                  │
 * │ - UML_RegularSeparator : String                                                          │
 * │ - UML_Title : String                                                                     │
 * │ - UML_VariableNamePrefix : String                                                        │
 * │ - UML_VariableToMethodPartition : String                                                 │
 * ├┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┤
 * │ + ConsoleInput() : String                                                                │
 * │ + ExecuteRules(x:String, SnippetLength:int, rules:ConditionalReplacement...) : String    │
 * │ + main(StringArray:String[]) : void                                                      │
 * │ + ReplaceFirst(Original:String, OldSnippet:String, NewSnippet:String) : String           │
 * │ + Rule(Condition:rStringToBoolean, Replacement:rStringToString) : ConditionalReplacement │
 * │ + StringFromClipboard() : String                                                         │
 * │ + StringToClipboard(myString:Object) : void                                              │
 * ╰──────────────────────────────────────────────────────────────────────────────────────────╯
 * ╭───────────────────────────────────────────────────────────────────────╮
 * │ r                                                                     │
 * ├┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┤
 * │ - Complex : class                                                     │
 * │ - DEG_PER_RAD : double                                                │
 * │ - DEG_TO_RAD : double                                                 │
 * │ - E : double                                                          │
 * │ - PI : double                                                         │
 * │ - RAD_PER_DEG : double                                                │
 * │ - RAD_TO_DEG : double                                                 │
 * │ - TWO_PI : double                                                     │
 * ├┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┤
 * │ + abs(x:Complex) : double                                             │
 * │ + abs(x:double) : double                                              │
 * │ + acos(x:double) : double                                             │
 * │ + acosh(x:double) : double                                            │
 * │ + acot(x:double) : double                                             │
 * │ + acoth(x:double) : double                                            │
 * │ + acsc(x:double) : double                                             │
 * │ + acsch(x:double) : double                                            │
 * │ + add(a:double, b:double, x:double, y:double) : Complex               │
 * │ + add(X:Complex, Y:Complex) : Complex                                 │
 * │ + angleOf(x:double, y:double) : double                                │
 * │ + arg(x:Complex) : double                                             │
 * │ + asec(x:double) : double                                             │
 * │ + asech(x:double) : double                                            │
 * │ + asin(x:double) : double                                             │
 * │ + asinh(x:double) : double                                            │
 * │ + atan(x:double) : double                                             │
 * │ + atanh(x:double) : double                                            │
 * │ + Boolean(x:int) : boolean                                            │
 * │ + booleanScan() : boolean                                             │
 * │ + ceil(x:double) : long                                               │
 * │ + chance(Probability:double) : boolean                                │
 * │ + complex(real:double, imag:double) : Complex                         │
 * │ + cos(x:double) : double                                              │
 * │ + cosh(x:double) : double                                             │
 * │ + cot(x:double) : double                                              │
 * │ + coth(x:double) : double                                             │
 * │ + csc(x:double) : double                                              │
 * │ + csch(x:double) : double                                             │
 * │ + delay(delayDurationInSeconds:double) : void                         │
 * │ + delayInMillis(delayDurationInMilliseconds:long) : void              │
 * │ + distance(X:double, Y:double, x:double, y:double) : double           │
 * │ + div(a:double, b:double, x:double, y:double) : Complex               │
 * │ + div(X:Complex, Y:Complex) : Complex                                 │
 * │ + Double(Input:String) : double                                       │
 * │ + doubleScan() : double                                               │
 * │ + exp(a:double, b:double) : Complex                                   │
 * │ + exp(X:Complex) : Complex                                            │
 * │ + exp(x:double) : double                                              │
 * │ + factorial(x:long) : long                                            │
 * │ + floatScan() : float                                                 │
 * │ + floor(x:double) : long                                              │
 * │ + im(imag:double) : Complex                                           │
 * │ + im(x:Complex) : double                                              │
 * │ + imag(imag:double) : Complex                                         │
 * │ + imag(x:Complex) : double                                            │
 * │ + Int(Input:String) : double                                          │
 * │ + Int(x:boolean) : int                                                │
 * │ + intScan() : int                                                     │
 * │ + ln(a:double, b:double) : Complex                                    │
 * │ + ln(X:Complex) : Complex                                             │
 * │ + ln(x:double) : double                                               │
 * │ + log(Base:Complex, X:Complex) : Complex                              │
 * │ + log(Base_a:double, Base_b:double, X_x:double, X_y:double) : Complex │
 * │ + Long(Input:String) : double                                         │
 * │ + longScan() : long                                                   │
 * │ + mag(x:double, y:double) : double                                    │
 * │ + max(x:double, y:double) : double                                    │
 * │ + millis() : long                                                     │
 * │ + min(x:double, y:double) : double                                    │
 * │ + mouseX() : int                                                      │
 * │ + mouseY() : int                                                      │
 * │ + mult(a:double, b:double, x:double, y:double) : Complex              │
 * │ + mult(X:Complex, Y:Complex) : Complex                                │
 * │ + pow(a:double, b:double, x:double, y:double) : Complex               │
 * │ + pow(X:Complex, Y:Complex) : Complex                                 │
 * │ + print(message:BigDecimal) : void                                    │
 * │ + print(message:boolean) : void                                       │
 * │ + print(message:char) : void                                          │
 * │ + print(message:double) : void                                        │
 * │ + print(message:long) : void                                          │
 * │ + print(message:String) : void                                        │
 * │ + println() : void                                                    │
 * │ + println(message:BigDecimal) : void                                  │
 * │ + println(message:boolean) : void                                     │
 * │ + println(message:char) : void                                        │
 * │ + println(message:double) : void                                      │
 * │ + println(message:long) : void                                        │
 * │ + println(message:String) : void                                      │
 * │ + random(x:double) : double                                           │
 * │ + randomInt(x:double) : int                                           │
 * │ + re(real:double) : Complex                                           │
 * │ + re(x:Complex) : double                                              │
 * │ + real(real:double) : Complex                                         │
 * │ + real(x:Complex) : double                                            │
 * │ + round(x:double) : long                                              │
 * │ + scan() : String                                                     │
 * │ + scan(Message:String) : String                                       │
 * │ + sec(x:double) : double                                              │
 * │ + sech(x:double) : double                                             │
 * │ + seconds() : double                                                  │
 * │ + sign(x:double) : double                                             │
 * │ + sign(x:float) : float                                               │
 * │ + sin(x:double) : double                                              │
 * │ + sinh(x:double) : double                                             │
 * │ + sqrt(X:Complex) : Complex                                           │
 * │ + sqrt(x:double) : double                                             │
 * │ + StringDialog() : String                                             │
 * │ + StringDialog(message:String) : String                               │
 * │ + StringFromClipboard() : String                                      │
 * │ + StringScan() : String                                               │
 * │ + StringToClipboard(myStringToCopy:Object) : void                     │
 * │ + sub(a:double, b:double, x:double, y:double) : Complex               │
 * │ + sub(X:Complex, Y:Complex) : Complex                                 │
 * │ + tan(x:double) : double                                              │
 * │ + tanh(x:double) : double                                             │
 * ╰───────────────────────────────────────────────────────────────────────╯
 * ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
 * ┃ Account                                                   ┃
 * ┠───────────────────────────────────────────────────────────┨
 * ┃ (No Variables)                                            ┃
 * ┠┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┨
 * ┃ + Account()                                               ┃
 * ┃ + Account(a:int, b:double)                                ┃
 * ┃ + deposit(a:double) : void                                ┃
 * ┃ + getAnnualInterestRate() : double                        ┃
 * ┃ + getBalance() : double                                   ┃
 * ┃ + getDateCreated() : Date                                 ┃
 * ┃ + getId() : int                                           ┃
 * ┃ + getMonthlyInterestRate() : double                       ┃
 * ┃ + setAnnualInterestRate(annualInterestRate:double) : void ┃
 * ┃ + setBalance(balance:double) : void                       ┃
 * ┃ + setDateCreated(dateCreated:Date) : void                 ┃
 * ┃ + setId(id:int) : void                                    ┃
 * ┃ + toString() : String                                     ┃
 * ┃ + withDraw(a:double) : void                               ┃
 * ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
 */
class UniversalVariables
{
    public static boolean IgnoreDoubles=true;//this value is never used; it is a tag that is changed on the fly from document to document
    public static boolean selectall=false;
    public static boolean deselect=false;
    public static boolean HideLevel1=false;
}