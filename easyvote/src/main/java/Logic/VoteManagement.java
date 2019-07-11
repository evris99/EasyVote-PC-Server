package Logic;

import java.util.ArrayList;
import Logic.HandRules.HandRuleRequest;

public class VoteManagement {

  // Array with every hand rule request that is active
  private ArrayList<HandRuleRequest> requests = new ArrayList<>();
  private HandRules handRules = new HandRules();

  public void createVotingSession(String typeOfSession) {
    // typeOfSession determines the kind of voting that will take place during
    // the session. For example, ROP votes that require yes/no answers, Board
    // Elections
    // that require name answers etc.

  }

  // Add the new request and then sort them all again
  public void handRuleAdded(String handRule, int id) {
    requests.add(handRules.new HandRuleRequest(handRule, id));
    requests.sort(handRules.comparator);
  }

  //Change the attribute of the request based on user's option
  public void changeHandRuleAttribute(String newAttr, int id) {

    switch (newAttr) {
      case "FINISH_SPEAKING_TURN":
        // Remove the first element
        requests.remove(0);
        break;
      case "PASS_SPEAKING_TURN":
        for (int i = 0; i < requests.size(); i++) {
          if (requests.get(i).getId() == id) {
            //Remove the requested element as desired
            requests.remove(i);
          }
        }
      default:
        System.out.println("Something went wrong.");
        break;
    }
  }


}
