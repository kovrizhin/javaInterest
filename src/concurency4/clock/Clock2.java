package concurency4.clock;// Clock2.java

// Type Ctrl+C (or equivalent keystroke combination on non-Windows platform)
// to terminate.

import java.util.*;

class Clock2
{
   public static void main (String [] args)
   {
      Timer t = new Timer ();

      t.scheduleAtFixedRate (new TimerTask ()
                             {
                                public void run ()
                                {
                                   System.out.println (new Date ().
                                                       toString ());
                                }
                             },
                             0,
                             1000);
   }
}
