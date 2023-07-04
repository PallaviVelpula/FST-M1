player1 = input("Enter Player 1: ")
player2 = input("Enter Player 2: ")
while True:
    player1_choice = input(player1 + ", do you want to choose rock, paper or scissors? ").lower()
    player2_choice = input(player2 + ", do you want to choose rock, paper or scissors? ").lower()

    if player1_choice == player2_choice:
        print("It's a tie")
    elif player1_choice == "rock":
        if player2_choice == "paper":
            print("{} wins".format(player2))
        elif player2_choice == "scissors":
            print("{} wins".format(player1))
        else:
            print("{}'s choice is incorrect".format(player2))
    elif player1_choice == "paper":
        if player2_choice == "rock":
            print("{} wins".format(player1))
        elif player2_choice == "scissors":
            print("{} wins".format(player2))
        else:
            print("{}'s choice is incorrect".format(player2))
    elif player1_choice == "scissors":
        if player2_choice == "rock":
            print("{} wins".format(player2))
        elif player2_choice == "paper":
            print("{} wins".format(player1))
        else:
            print("{}'s choice is incorrect".format(player2))
    else:
        print("{}'s choice is incorrect".format(player1))
    repeat = input("Do you want to continue? Yes/No: ").lower()
    if repeat == "yes":
        pass
    elif repeat == "no":
        raise SystemExit
    else:
        print("Invalid option. Exiting now")
        raise SystemExit
