// by Dan Joyce
// solves Problem 4: Call Forwarding 
// of 1996 Mid Atlantic programming contest

// input lists info about when calls to extensions ring another extnsn 
// output tells which extension will actual ring 

import java.io.*;
import common.doinput; 

class problem4 {

  public static void main (String [] args) throws IOException {

    String forward [][] = new String [101][4];  // forwarding data
                                                // source time duration target
    int N;                // number of systems 
    String willring;      // the extension that will ring
    boolean madechange;   // true if another forward found    
    int fcount;           // how many forwardings found this time
    int i;                // used to index forward array
    int fsize;            // size of valid part of forward array
    String source, extension, time;
    int curtime, testtime, testdur;

    doinput myinput = new doinput();

    System.out.println ("CALL FORWARDING OUTPUT");

    N = myinput.nextint();

    for (int count = 1; count <= N; count++)
      {
      System.out.println("SYSTEM " + count);
      source = myinput.nextsubstring();
      i = 0;
      while (!source.equals("0000")) {
        i = i + 1;                      // not using forward[0]
        forward[i][0] = source;
        forward[i][1] = myinput.nextsubstring();
        forward[i][2] = myinput.nextsubstring();
        forward[i][3] = myinput.nextsubstring();
        source = myinput.nextsubstring();
        };
      fsize = i;
      time = myinput.nextsubstring();
      while (!time.equals("9000")) {
         extension = myinput.nextsubstring();
         willring = extension;
         // an easy, inelegant way to discover degenerate situations
         // ie loops in the forwarding chain is to just count how
         // many forwarding were discovered ... if this goes over
         // 100 then stop searching and forward to 9999 ... thus
         // I use fcount to count the number of forwardings found
         fcount = 0;
         madechange = true;   // continue trying if a forward was found
         while ((fcount <= 102) && madechange) {
            madechange = false;
            for (i = 1; i <= fsize; i++) {
               curtime = Integer.parseInt(time);
               testtime = Integer.parseInt(forward[i][1]);
               testdur = Integer.parseInt(forward[i][2]);
               if ((willring.equals(forward[i][0]))
                   &&
                   (curtime >= testtime)
                   &&
                   (curtime <= ( testtime + testdur)))
                   {fcount = fcount + 1;
                    madechange = true;
                    willring = forward[i][3];
                   };
                };
             };
         if (fcount >= 101) willring = "9999";
         System.out.print("AT " + time + " CALL TO " + extension);
         System.out.println(" RINGS " + willring);
         time = myinput.nextsubstring();
         };
      }; 

    System.out.println ("END OF OUTPUT");
  }
}

