package com.example.myapplication

import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupWindow
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class GameWindow : AppCompatActivity() {
    var options = arrayOf("1", "2", "3", "4", "5")

    private var diceValues = mutableListOf<Int>()
    private var rollsLeft = 3

    private lateinit var roll_text: TextView
    private lateinit var roll_text2: TextView
    private lateinit var compTotal: TextView
    private lateinit var humanTotal: TextView


    var sum = 0
    var lastCompThrowSum = 0
    var sumComputerTotal = 0
    var sum2 = 0
    var lastHumanThrowSum = 0
    var sumHumanTotal = 0
    var totalScore = 0

    var rerollsNumber = 0
    var hasScored = false
    var currentRound = 1

    private var defaultPosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_window)

        var rollBtn: Button = findViewById(R.id.throwBtn)
        var score: Button = findViewById(R.id.scoreBtn)
        roll_text = findViewById(R.id.compScore)
        roll_text2 = findViewById(R.id.humanScore)
        compTotal = findViewById(R.id.currentTotalCpu)
        humanTotal = findViewById(R.id.currentTotalHuman)
        var rerollBtn = findViewById<Button>(R.id.reroll)

        if (savedInstanceState != null) {
            roll_text.text = savedInstanceState.getInt("rollText").toString()
            roll_text2.text = savedInstanceState.getInt("rollText2").toString()
            sumComputerTotal = savedInstanceState.getInt("sumComputerTotal")
            sumHumanTotal = savedInstanceState.getInt("sumHumanTotal")
        }
        compTotal.text = sumComputerTotal.toString()
        humanTotal.text = sumHumanTotal.toString()

        rollBtn.setOnClickListener {
            rollDice()
            rerollBtn.isEnabled = true
            hasScored = false
        }

        rerollBtn.setOnClickListener {
            var selectedItem = findViewById<TextView>(R.id.itemSelected)
            // Enable the roll button
            rollBtn.isEnabled = true
            // Reset the hasScored flag

            val builderSingle = AlertDialog.Builder(this)
            builderSingle.setTitle("Select a dice to keep")
            builderSingle.setPositiveButton(getString(android.R.string.ok)) { dialog, _ -> dialog.dismiss() }
            builderSingle.setSingleChoiceItems(options, defaultPosition) { dialog, which ->
                defaultPosition = which
                val selectedOption = options[which]
                selectedItem.text = selectedOption
                val selectedDice = selectedOption.toInt()
                rerollDice(selectedDice)
                hasScored = true
            }
            builderSingle.show()
        }

        score.setOnClickListener {
            hasScored = true
            // Disable the roll button and reroll button
            rollBtn.isEnabled = false
            rerollBtn.isEnabled = false
        }
    }

    private fun rollDice() {

        var rollBtn: Button = findViewById(R.id.throwBtn)
        //creating a dice object and rolling
        val dice1 = Dice(6)
        val dice2 = Dice(6)
        val dice3 = Dice(6)
        val dice4 = Dice(6)
        val dice5 = Dice(6)
        val dice6 = Dice(6)
        val dice7 = Dice(6)
        val dice8 = Dice(6)
        val dice9 = Dice(6)
        val dice10 = Dice(6)

        val diceRoll1 = dice1.roll()
        val diceRoll2 = dice2.roll()
        val diceRoll3 = dice3.roll()
        val diceRoll4 = dice4.roll()
        val diceRoll5 = dice5.roll()
        val diceRoll6 = dice6.roll()
        val diceRoll7 = dice7.roll()
        val diceRoll8 = dice8.roll()
        val diceRoll9 = dice9.roll()
        val diceRoll10 = dice10.roll()


        //finding the imageview by id
        val diceImage1: ImageView = findViewById(R.id.imageView1)
        val diceImage2: ImageView = findViewById(R.id.imageView6)
        val diceImage3: ImageView = findViewById(R.id.imageView2)
        val diceImage4: ImageView = findViewById(R.id.imageView7)
        val diceImage5: ImageView = findViewById(R.id.imageView3)
        val diceImage6: ImageView = findViewById(R.id.imageView8)
        val diceImage7: ImageView = findViewById(R.id.imageView4)
        val diceImage8: ImageView = findViewById(R.id.imageView9)
        val diceImage9: ImageView = findViewById(R.id.imageView5)
        val diceImage10: ImageView = findViewById(R.id.imageView10)

        //drawable resource id based on the dice roll
        val drawableRes1 = when (diceRoll1) {
            1 -> R.drawable.die_face_1
            2 -> R.drawable.die_face_2
            3 -> R.drawable.die_face_3
            4 -> R.drawable.die_face_4
            5 -> R.drawable.die_face_5
            else -> {
                R.drawable.die_face_6
            }
        }

        val drawableRes2 = when (diceRoll2) {
            1 -> R.drawable.die_face_1
            2 -> R.drawable.die_face_2
            3 -> R.drawable.die_face_3
            4 -> R.drawable.die_face_4
            5 -> R.drawable.die_face_5
            else -> {
                R.drawable.die_face_6
            }
        }

        val drawableRes3 = when (diceRoll3) {
            1 -> R.drawable.die_face_1
            2 -> R.drawable.die_face_2
            3 -> R.drawable.die_face_3
            4 -> R.drawable.die_face_4
            5 -> R.drawable.die_face_5
            else -> {
                R.drawable.die_face_6
            }
        }

        val drawableRes4 = when (diceRoll4) {
            1 -> R.drawable.die_face_1
            2 -> R.drawable.die_face_2
            3 -> R.drawable.die_face_3
            4 -> R.drawable.die_face_4
            5 -> R.drawable.die_face_5
            else -> {
                R.drawable.die_face_6
            }
        }

        val drawableRes5 = when (diceRoll5) {
            1 -> R.drawable.die_face_1
            2 -> R.drawable.die_face_2
            3 -> R.drawable.die_face_3
            4 -> R.drawable.die_face_4
            5 -> R.drawable.die_face_5
            else -> {
                R.drawable.die_face_6
            }
        }

        val drawableRes6 = when (diceRoll6) {
            1 -> R.drawable.die_face_1
            2 -> R.drawable.die_face_2
            3 -> R.drawable.die_face_3
            4 -> R.drawable.die_face_4
            5 -> R.drawable.die_face_5
            else -> {
                R.drawable.die_face_6
            }
        }

        val drawableRes7 = when (diceRoll7) {
            1 -> R.drawable.die_face_1
            2 -> R.drawable.die_face_2
            3 -> R.drawable.die_face_3
            4 -> R.drawable.die_face_4
            5 -> R.drawable.die_face_5
            else -> {
                R.drawable.die_face_6
            }
        }

        val drawableRes8 = when (diceRoll8) {
            1 -> R.drawable.die_face_1
            2 -> R.drawable.die_face_2
            3 -> R.drawable.die_face_3
            4 -> R.drawable.die_face_4
            5 -> R.drawable.die_face_5
            else -> {
                R.drawable.die_face_6
            }
        }

        val drawableRes9 = when (diceRoll9) {
            1 -> R.drawable.die_face_1
            2 -> R.drawable.die_face_2
            3 -> R.drawable.die_face_3
            4 -> R.drawable.die_face_4
            5 -> R.drawable.die_face_5
            else -> {
                R.drawable.die_face_6
            }
        }

        val drawableRes10 = when (diceRoll10) {
            1 -> R.drawable.die_face_1
            2 -> R.drawable.die_face_2
            3 -> R.drawable.die_face_3
            4 -> R.drawable.die_face_4
            5 -> R.drawable.die_face_5
            else -> {
                R.drawable.die_face_6
            }
        }

        //matching the image view with the drawable resource id
        diceImage1.setImageResource(drawableRes1)
        diceImage2.setImageResource(drawableRes2)
        diceImage3.setImageResource(drawableRes3)
        diceImage4.setImageResource(drawableRes4)
        diceImage5.setImageResource(drawableRes5)
        diceImage6.setImageResource(drawableRes6)
        diceImage7.setImageResource(drawableRes7)
        diceImage8.setImageResource(drawableRes8)
        diceImage9.setImageResource(drawableRes9)
        diceImage10.setImageResource(drawableRes10)


        //updating the content description
        diceImage1.contentDescription = diceRoll1.toString()
        diceImage2.contentDescription = diceRoll2.toString()
        diceImage3.contentDescription = diceRoll3.toString()
        diceImage4.contentDescription = diceRoll4.toString()
        diceImage5.contentDescription = diceRoll5.toString()
        diceImage6.contentDescription = diceRoll6.toString()
        diceImage7.contentDescription = diceRoll7.toString()
        diceImage8.contentDescription = diceRoll8.toString()
        diceImage9.contentDescription = diceRoll9.toString()
        diceImage10.contentDescription = diceRoll10.toString()

        //converting the results of five dices into string and then to integers
        val tvText1 = diceRoll1.toString().toInt()
        val tvText2 = diceRoll3.toString().toInt()
        val tvText3 = diceRoll5.toString().toInt()
        val tvText4 = diceRoll7.toString().toInt()
        val tvText5 = diceRoll9.toString().toInt()


        sum = tvText1 + tvText2 + tvText3 + tvText4 + tvText5
        lastCompThrowSum = sum
        roll_text.text = "$sum"  //displaying the sum of the numbers shown on the faces of the dice.

        val tvText6 = diceRoll2.toString().toInt()
        val tvText7 = diceRoll4.toString().toInt()
        val tvText8 = diceRoll6.toString().toInt()
        val tvText9 = diceRoll8.toString().toInt()
        val tvText10 = diceRoll10.toString().toInt()

        sum2 = tvText6 + tvText7 + tvText8 + tvText9 + tvText10
        lastHumanThrowSum = sum2
        roll_text2.text = "$sum2"

        findViewById<Button>(R.id.scoreBtn).setOnClickListener {
            currentRound++
            if (humanTotal.text.toString().toInt() >= 110) {
                findViewById<Button>(R.id.throwBtn).isEnabled = false
                findViewById<Button>(R.id.scoreBtn).isEnabled = false
                findViewById<Button>(R.id.reroll).isEnabled = false
            }

            var rollBtn: Button = findViewById(R.id.throwBtn)
            var rerollBtn: Button = findViewById(R.id.reroll)

            hasScored = true
            rollBtn.isEnabled = true

            sumComputerTotal += lastCompThrowSum
            compTotal.text = "$sumComputerTotal"  //current total score for the computer player

            sumHumanTotal += lastHumanThrowSum
            humanTotal.text = "$sumHumanTotal"   //current total score for the human player
        }
        rollBtn.isEnabled = false
    }

    private fun rerollDice(selectedDice: Int) {
        var targetScore = findViewById<TextView>(R.id.targetScore_101)
        var buttonClicked = false
        findViewById<Button>(R.id.throwBtn).setOnClickListener {
            if (buttonClicked || rerollsNumber > 1) {
                rollDice()
            } else {
                buttonClicked = true
                var rerollSum2 = 0
                rerollsNumber++
                val selectedDiceObject = Dice(selectedDice)
                val selectedDiceRoll = selectedDiceObject.roll()

                fun getDrawableRes(roll: Any): Int {
                    return when (roll) {
                        1 -> R.drawable.die_face_1
                        2 -> R.drawable.die_face_2
                        3 -> R.drawable.die_face_3
                        4 -> R.drawable.die_face_4
                        5 -> R.drawable.die_face_5
                        else -> R.drawable.die_face_6
                    }
                }
                for (option in options) {
                    val diceValue = option.toInt()
                    if (diceValue != selectedDice) {
                        val dice = Dice(diceValue)
                        val rollResult = dice.roll()
                        val drawableRes = getDrawableRes(rollResult)
                        val imageView: ImageView = when (diceValue) {
                            1 -> findViewById(R.id.imageView6)
                            2 -> findViewById(R.id.imageView7)
                            3 -> findViewById(R.id.imageView8)
                            4 -> findViewById(R.id.imageView9)
                            5 -> findViewById(R.id.imageView10)
                            else -> throw IllegalArgumentException()
                        }
                        imageView.setImageResource(drawableRes)
                        rerollSum2 += rollResult.toString().toInt()
                        lastHumanThrowSum = rerollSum2
                    }
                    roll_text2.text = "$rerollSum2"
                }
                findViewById<Button>(R.id.scoreBtn).setOnClickListener {
                    sumHumanTotal += lastHumanThrowSum
                    humanTotal.text = "$sumHumanTotal"

                    sumComputerTotal += lastCompThrowSum
                    compTotal.text = "$sumComputerTotal"

                    rerollsNumber = 0
                    findViewById<Button>(R.id.reroll).isEnabled = true
                }
                findViewById<Button>(R.id.throwBtn).isEnabled = false

                // Update UI for total score and enable buttons
                humanTotal.text = totalScore.toString()
                findViewById<Button>(R.id.throwBtn).isEnabled = true
                findViewById<Button>(R.id.scoreBtn).isEnabled = true
                findViewById<Button>(R.id.reroll).isEnabled = true
            }
            if (rerollsNumber == 2 && buttonClicked) {
                rerollsNumber = 0
                sumHumanTotal += lastHumanThrowSum
                humanTotal.text = "$sumHumanTotal"

                sumComputerTotal += lastCompThrowSum
                compTotal.text = "$sumComputerTotal"
            }
            if (humanTotal.text.toString().toInt() > 101 || compTotal.text.toString().toInt() > 101
            ) {
                findViewById<Button>(R.id.throwBtn).isEnabled = false
                findViewById<Button>(R.id.scoreBtn).isEnabled = false
                findViewById<Button>(R.id.reroll).isEnabled = false

                if (humanTotal.text.toString().toInt() > compTotal.text.toString().toInt()) {
                    val popupView = layoutInflater.inflate(R.layout.score_results, null)
                    val popupWindow = PopupWindow(
                        popupView,
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        true
                    )
                    findViewById<TextView>(R.id.resultTextView)
                    popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0)
                    val closeButton = popupView.findViewById<Button>(R.id.closeButton)
                    closeButton.setOnClickListener {
                        popupWindow.dismiss()
                    }
                } else if (humanTotal.text.toString().toInt() == compTotal.text.toString()   //tie part
                        .toInt()
                ) {
                    findViewById<Button>(R.id.reroll).isEnabled = false
                    do {
                        sumHumanTotal += lastHumanThrowSum
                        sumComputerTotal += lastCompThrowSum

                    } while (sumHumanTotal == sumComputerTotal)

                    if (sumHumanTotal > sumComputerTotal) {
                        val popupView = layoutInflater.inflate(R.layout.score_results, null)
                        val popupWindow = PopupWindow(
                            popupView,
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            true
                        )
                        findViewById<TextView>(R.id.resultTextView)
                        popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0)
                        val closeButton = popupView.findViewById<Button>(R.id.closeButton)
                        closeButton.setOnClickListener {
                            popupWindow.dismiss()
                        }
                    } else {
                        val popupView = layoutInflater.inflate(R.layout.score_results2, null)
                        val popupWindow = PopupWindow(
                            popupView,
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            true
                        )
                        findViewById<TextView>(R.id.resultTextView2)
                        popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0)
                        val closeButton = popupView.findViewById<Button>(R.id.closeButton)
                        closeButton.setOnClickListener {
                            popupWindow.dismiss()
                        }
                    }
                } else {
                    val popupView = layoutInflater.inflate(R.layout.score_results2, null)
                    val popupWindow = PopupWindow(
                        popupView,
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        true
                    )
                    findViewById<TextView>(R.id.resultTextView2)
                    popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0)
                    val closeButton = popupView.findViewById<Button>(R.id.closeButton)
                    closeButton.setOnClickListener {
                        popupWindow.dismiss()
                    }
                }
            }
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("rollText", roll_text.text.toString().toInt())
        outState.putInt("rollText2", roll_text2.text.toString().toInt())
        outState.putInt("sumComputerTotal", sumComputerTotal)
        outState.putInt("sumHumanTotal", sumHumanTotal)
    }

    //computer players random strategy
    private fun compRollDice() {
        if (rollsLeft == 0) {

        }

        // Roll all five dice
        diceValues.clear()
        for (i in 1..5) {
            if (!diceToKeep(i)) {
                val value = Random.nextInt(1, 7)
                diceValues.add(value)
            }
        }

        // Update the dice images
        findViewById<ImageView>(R.id.imageView1).setImageResource(getDiceImage(diceValues[0]))
        findViewById<ImageView>(R.id.imageView2).setImageResource(getDiceImage(diceValues[1]))
        findViewById<ImageView>(R.id.imageView3).setImageResource(getDiceImage(diceValues[2]))
        findViewById<ImageView>(R.id.imageView4).setImageResource(getDiceImage(diceValues[3]))
        findViewById<ImageView>(R.id.imageView5).setImageResource(getDiceImage(diceValues[4]))

        rollsLeft -= 1
    }

    private fun diceToKeep(index: Int): Boolean {
        // Randomly decide which dice to keep
        return Random.nextBoolean()
    }

    private fun score() {
        var totalScore = 0
        for (i in 1..3) {
            rollDice()
            val score = calculateScore(diceValues)
            totalScore += score
        }
        rollsLeft = 3
    }

    private fun getDiceImage(value: Int): Int {
        return when (value) {
            1 -> R.drawable.die_face_1
            2 -> R.drawable.die_face_2
            3 -> R.drawable.die_face_3
            4 -> R.drawable.die_face_4
            5 -> R.drawable.die_face_5
            else -> R.drawable.die_face_6
        }
    }

    private fun calculateScore(diceValues: List<Int>): Int {
        var score = 0
        for (value in diceValues) {
            score += value
        }
        return score
    }

    private fun updateDiceViews() {
        fun getDrawableRes(roll: Any): Int {
            return when (roll) {
                1 -> R.drawable.die_face_1
                2 -> R.drawable.die_face_2
                3 -> R.drawable.die_face_3
                4 -> R.drawable.die_face_4
                5 -> R.drawable.die_face_5
                else -> R.drawable.die_face_6
            }
        }
    }
    private fun humanPlayerClickedThrowButton(): Boolean {
        return true
    }

    class Dice(private val numSides: Int) {
        fun roll(): Any {
            return (1..6).random()
        }
    }
}















