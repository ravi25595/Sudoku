package pocketexam.zyrosite.sudoku;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

class SudokuBoard extends View {
    private final int boardColor;
    private final Paint boarderColorPaint = new Paint();

    public SudokuBoard(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.SudokuBoard, 0, 0);
        try {
            boardColor = typedArray.getInteger(R.styleable.SudokuBoard_boardColor, 0);
        } finally {
            typedArray.recycle();
        }
    }

    @Override
    protected void onMeasure(int width, int height) {
        super.onMeasure(width, height);
        int dimension = Math.min(this.getWidth(), this.getHeight());
        setMeasuredDimension(dimension, dimension);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        boarderColorPaint.setStyle(Paint.Style.STROKE);
        boarderColorPaint.setStrokeWidth(16);
        boarderColorPaint.setColor(boardColor);
        boarderColorPaint.setAntiAlias(true);
        canvas.drawRect(0, 0, getWidth(), getHeight(), boarderColorPaint);
    }
}
