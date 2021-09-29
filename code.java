  public static int[] scoring(boolean p, boolean a){
    int tempPlayerYears = 0;
    int tempAgentYears  = 0;

    int[] outputArray = new int[2];

    if(p == true && a == true){
        tempPlayerYears = 2;
        tempAgentYears  = 2;
    }

    else if(p == true && a == false){
        tempPlayerYears = 0;
        tempAgentYears  = 3;
    }

    else if (p == false && a == true){
        tempPlayerYears = 3;
        tempAgentYears  = 0;
    }
    else if (p == false && a == false){
        tempPlayerYears = 1;
        tempAgentYears  = 1;
    }

    //Player choice at index 0
    outputArray[0] = tempPlayerYears;

    //Player choice at index 1
    outputArray[1] = tempAgentYears;

    return(outputArray);
  }
}