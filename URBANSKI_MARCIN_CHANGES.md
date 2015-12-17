# Changes description

Here is short list of steps:

1. Implementation of tests, that cover rules specified in README.md
2. Refactoring and rearranging of code
3. Applying strategy pattern
    - Easy way of adding new features
    - Improvement of code readability
    - Cleaner structure
    - More "objective" approach than previous
    - Behaviour of items depends on strategy not on name of item -> items could have different names and same behaviour
4. Refactoring of tests
5. Applying new "Fresh Baked Bread" strategy
6. Refactoring of tests and code
    
# Git log

commit b7dc2ef65561b743ceca2e5a88a5781917946b7f
Author: marc-inn <marcinn.urbanski@gmail.com>
Date:   Thu Dec 17 19:19:48 2015 +0100

    Refactor names
    
    - change name updateQuality -> updateSellInAndQuality

commit 7fa66866282ca2800cee57700966ff9e91b83953
Author: marc-inn <marcinn.urbanski@gmail.com>
Date:   Thu Dec 17 19:14:33 2015 +0100

    Remove unnecessary test

commit 58fb7bfe6469591be8a89f8804510ea01317ab28
Author: marc-inn <marcinn.urbanski@gmail.com>
Date:   Thu Dec 17 15:08:52 2015 +0100

    Create const values for minimum/maximum qualities

commit 64dffd451d7024299f319efffd1720c3822708ec
Author: marc-inn <marcinn.urbanski@gmail.com>
Date:   Thu Dec 17 15:01:32 2015 +0100

    Refactor test about fresh backed bread quality strategy

commit 1b87a05c1f7d0144b7125ab01598784dd0547ce4
Author: marc-inn <marcinn.urbanski@gmail.com>
Date:   Thu Dec 17 15:00:38 2015 +0100

    Add implementation of fresh backed bread quality strategy

commit 932e704ee0a9655082cf37ec85ac9b4a5ed0a41f
Author: marc-inn <marcinn.urbanski@gmail.com>
Date:   Thu Dec 17 14:53:38 2015 +0100

    Move strategies to different package

commit cd9e610dfaa12324e5c5a7b8d7891bd7284465a6
Author: marc-inn <marcinn.urbanski@gmail.com>
Date:   Thu Dec 17 14:52:07 2015 +0100

    Refactor test to use strategies class instead of names to check assertions

commit 0bd2ea7ca41535ef1364e702e0a8acd97f6ea6de
Author: marc-inn <marcinn.urbanski@gmail.com>
Date:   Thu Dec 17 14:46:19 2015 +0100

    Add final implementation of simple quality strategy

commit 1a5c548cd60743a9b6d3093ac5054a7fcbbc9916
Author: marc-inn <marcinn.urbanski@gmail.com>
Date:   Thu Dec 17 14:39:34 2015 +0100

    Add implementation of gold quality strategy

commit e5511168cd9388ee9384681b38ffb213fe7d2055
Author: marc-inn <marcinn.urbanski@gmail.com>
Date:   Thu Dec 17 14:33:38 2015 +0100

    Refactor strategy to be able to count sell in

commit d13c4b0fdda50a1e34187343f610cdb13bc0ff38
Author: marc-inn <marcinn.urbanski@gmail.com>
Date:   Thu Dec 17 14:28:23 2015 +0100

    Add implementation of wine quality strategy

commit 6e94feeb3315fde38cdd1100b01b76bdf2fa517b
Author: marc-inn <marcinn.urbanski@gmail.com>
Date:   Thu Dec 17 14:23:22 2015 +0100

    Add implementation of concert ticket strategy

commit c08df6f4ff5f34927e8ed10d20f1455d95966c0c
Author: marc-inn <marcinn.urbanski@gmail.com>
Date:   Thu Dec 17 13:39:49 2015 +0100

    Finish implementation of simple strategy

commit dc4b6123e9b57156119bfb38cb5da69a0c17837d
Author: marc-inn <marcinn.urbanski@gmail.com>
Date:   Thu Dec 17 13:24:46 2015 +0100

    Implement clone method for StrategyItem

commit 61498fec7226ced4f0e7cc00dd0171d458cceeb6
Author: marc-inn <marcinn.urbanski@gmail.com>
Date:   Thu Dec 17 13:21:32 2015 +0100

    Refactor Inventory System to be able to work with StrategyItem

commit bca9fa6c289d8250097272cada193fec7035de02
Author: marc-inn <marcinn.urbanski@gmail.com>
Date:   Thu Dec 17 13:18:54 2015 +0100

    Refactor tests to be able to work with StrategyItem

commit 8f25b9b27e8549e876256709244aed2634b2023f
Author: marc-inn <marcinn.urbanski@gmail.com>
Date:   Thu Dec 17 13:17:57 2015 +0100

    Add empty simple quality strategy

commit 19b31c52a2b55714c3cbe8916918c92de9e1b733
Author: marc-inn <marcinn.urbanski@gmail.com>
Date:   Thu Dec 17 11:50:55 2015 +0100

    Create container for item and quality strategy

commit 8e67cb5edfc3b30769fd51aae623ef0ed6fa3749
Author: marc-inn <marcinn.urbanski@gmail.com>
Date:   Thu Dec 17 11:48:34 2015 +0100

    Start implementing strategy pattern

commit 7656a8ce40d829eb7f1856de0b0e114096b51062
Author: marc-inn <marcinn.urbanski@gmail.com>
Date:   Thu Dec 17 11:42:23 2015 +0100

    Refactor for loop in updateQuality
    
    - Change for loop into foreach loop, in order to improve readability of code

commit a194aa8bce07d13c76066deb1ab06c3456501979
Author: marc-inn <marcinn.urbanski@gmail.com>
Date:   Thu Dec 17 00:55:23 2015 +0100

    Test rule "testOnceTheSellByDateHasPassed"
    
    - Once the sell by date has passed, Quality degrades twice as fast (i.e. the int is decremented by 2 instead of 1)

commit 919930c2f717149190f81ef94d1271ef9ee96ec0
Author: marc-inn <marcinn.urbanski@gmail.com>
Date:   Thu Dec 17 00:30:33 2015 +0100

    Test rule "testFreshBakedBreadShouldDecreaseInQuality"
    
    - The "Freshly baked bread" item degrade in Quality twice as fast as normal items

commit 3048a8db006790fb3cd573b7e10350ef24c27680
Author: marc-inn <marcinn.urbanski@gmail.com>
Date:   Thu Dec 17 00:25:47 2015 +0100

    Test rule "testConcertTicketShouldIncreaseInQuality"
    
    - "Concert Ticket", like Wine, increases in Quality as it's SellIn value reduces (i.e as it gets closer to the concert). Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but Quality drops to 0 after the concert

commit 723d98bde5d3b5dba39d03e056c0fea1fbd30caf
Author: marc-inn <marcinn.urbanski@gmail.com>
Date:   Thu Dec 17 00:00:04 2015 +0100

    Test rule "testGoldShouldNotDecreaseInQualityAndNeverHasToBeSold"
    
    - "Gold" never has to be sold or decreases in Quality

commit 8d6eb3e78e0ed71fe2aed5952eb0d1213d358170
Author: marc-inn <marcinn.urbanski@gmail.com>
Date:   Wed Dec 16 23:49:51 2015 +0100

    Test rule "testWineShouldIncreaseInQualityTheOlderItIs"
    
    - "Wine" actually increases in Quality the older it gets

commit 082bf197db0d1c4d07ff8ef1e308243502739688
Author: marc-inn <marcinn.urbanski@gmail.com>
Date:   Wed Dec 16 23:30:27 2015 +0100

    Test business rule "testQualityShouldNotBeBiggerThanSpecified"
    
    - The Quality of an item is never more than 50; except for "Gold" which can be 80.

commit 690f47fc71e84c575037a05e86de80a19e7f2805
Author: marc-inn <marcinn.urbanski@gmail.com>
Date:   Wed Dec 16 23:24:41 2015 +0100

    Improve est business rule "testQualityShouldNotBeNeverNegative"
    
    - Now test method is invoking updateQuality method multiple times
    - Fix typo in assertion condition

commit 654ffb775604afed2a0f85ecfc5e4668b0263fd3
Author: marc-inn <marcinn.urbanski@gmail.com>
Date:   Wed Dec 16 23:12:48 2015 +0100

    Test business rule "testQualityShouldNotBeNeverNegative"
    
    - The Quality of an item is never negative

commit 63578d1cf1e1584af47eb9582a3467798c3a015b
Author: marc-inn <marcinn.urbanski@gmail.com>
Date:   Wed Dec 16 23:10:53 2015 +0100

    Add test set up
    
    - Add getter and setter in InventorySystem
    - Add set up method in test

commit 3a19f46fb145ba469b476216583452cd29f4c438
Author: marc-inn <marcinn.urbanski@gmail.com>
Date:   Wed Dec 16 22:10:23 2015 +0100

    Commit uncommitted changes that were in ZIP file and not in repository

commit b9bb4ea6f732a20bb54e355dcdf5ffc854ee8830
Author: Keval Shah <keval.shah@corelogic.co.uk>
Date:   Fri Sep 25 14:15:22 2015 +0100

    Initial Commit
