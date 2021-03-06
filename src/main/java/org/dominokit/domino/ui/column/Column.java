package org.dominokit.domino.ui.column;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.div;

public class Column extends DominoElement<Column> implements IsElement<HTMLDivElement>, Cloneable {

    private HTMLDivElement column;
    private OnXLarge onXLargeStyle;
    private OnLarge onLargeStyle;
    private OnMedium onMediumStyle;
    private OnSmall onSmallStyle;
    private OnXSmall onXSmallStyle;
    private List<String> cssClasses = new ArrayList<>();

    private Column(HTMLDivElement htmlDivElement) {
        this.column = htmlDivElement;
        initCollapsible(this);
    }

    public static Column create() {
        return new Column(div().asElement());
    }

    public static Column create(int xLarge, int large, int medium, int small, int xsmall) {
        return create()
                .onXLarge(OnXLarge.of(xLarge))
                .onLarge(OnLarge.of(large))
                .onMedium(OnMedium.of(medium))
                .onSmall(OnSmall.of(small))
                .onXSmall(OnXSmall.of(xsmall));
    }

    public static Column create(int large, int medium, int small, int xsmall) {
        return create(large, large, medium, small, xsmall);
    }

    public static Column create(int mediumAnUp, int smallAndDown) {
        return create(mediumAnUp, mediumAnUp, mediumAnUp, smallAndDown, smallAndDown);
    }

    public static Column create(int columnsOnAllScreens) {
        return create()
                .onXLarge(OnXLarge.of(columnsOnAllScreens))
                .onLarge(OnLarge.of(columnsOnAllScreens))
                .onMedium(OnMedium.of(columnsOnAllScreens))
                .onSmall(OnSmall.of(columnsOnAllScreens))
                .onXSmall(OnXSmall.of(columnsOnAllScreens));
    }

    public static Column span1() {
        return create(1,12);
    }
    public static Column span2() {
        return create(2,12);
    }
    public static Column span3() {
        return create(3,12);
    }
    public static Column span4() {
        return create(4,12);
    }
    public static Column span5() {
        return create(5,12);
    }
    public static Column span6() {
        return create(6,12);
    }
    public static Column span7() {
        return create(7,12);
    }
    public static Column span8() {
        return create(8,12);
    }
    public static Column span9() {
        return create(9,12);
    }
    public static Column span10() {
        return create(10,12);
    }
    public static Column span11() {
        return create(11,12);
    }
    public static Column span12() {
        return create(12,12);
    }



    public Column copy() {
        Column column = Column.create();
        if (nonNull(this.onXLargeStyle))
            column.onXLarge(this.onXLargeStyle);
        if (nonNull(this.onLargeStyle))
            column.onLarge(this.onLargeStyle);
        if (nonNull(this.onMediumStyle))
            column.onMedium(this.onMediumStyle);
        if (nonNull(this.onSmallStyle))
            column.onSmall(this.onSmallStyle);
        if (nonNull(this.onXSmallStyle))
            column.onXSmall(this.onXSmallStyle);
        if (this.asElement().classList.contains(Styles.align_center))
            column.centerContent();

        for (int i = 0; i < cssClasses.size(); i++) {
            column.addCssClass(cssClasses.get(i));
        }

        return column;
    }

    public Column addElement(Node element) {
        this.asElement().appendChild(element);
        return this;
    }

    public Column addElement(IsElement<? extends HTMLElement> element) {
        this.asElement().appendChild(element.asElement());
        return this;
    }

    public Column onXLarge(OnXLarge onXLarge) {
        if (nonNull(this.onXLargeStyle))
            column.classList.remove(this.onXLargeStyle.getStyle());
        this.onXLargeStyle = onXLarge;
        column.classList.add(this.onXLargeStyle.getStyle());
        return this;
    }

    public Column onLarge(OnLarge onLarge) {
        if (nonNull(this.onLargeStyle))
            column.classList.remove(this.onLargeStyle.getStyle());
        this.onLargeStyle = onLarge;
        column.classList.add(this.onLargeStyle.getStyle());
        return this;
    }

    public Column onMedium(OnMedium onMedium) {
        if (nonNull(this.onMediumStyle))
            column.classList.remove(this.onMediumStyle.getStyle());
        this.onMediumStyle = onMedium;
        column.classList.add(this.onMediumStyle.getStyle());
        return this;
    }

    public Column onSmall(OnSmall onSmall) {
        if (nonNull(this.onSmallStyle))
            column.classList.remove(this.onSmallStyle.getStyle());
        this.onSmallStyle = onSmall;
        column.classList.add(this.onSmallStyle.getStyle());
        return this;
    }

    public Column onXSmall(OnXSmall onXSmall) {
        if (nonNull(this.onXSmallStyle))
            column.classList.remove(this.onXSmallStyle.getStyle());
        this.onXSmallStyle = onXSmall;
        column.classList.add(this.onXSmallStyle.getStyle());
        return this;
    }

    public Column centerContent() {
        asElement().classList.add(Styles.align_center);
        return this;
    }

    public Column deCenterContent() {
        asElement().classList.remove(Styles.align_center);
        return this;
    }

    public Column addCssClass(String cssClass) {
        this.asElement().classList.add(cssClass);
        this.cssClasses.add(cssClass);
        return this;
    }

    public Column removeCssClass(String cssClass) {
        this.asElement().classList.remove(cssClass);
        this.cssClasses.remove(cssClass);
        return this;
    }

    public Column condenced() {
        return Style.of(this).setMarginBottom("0px").get();
    }

    @Override
    public HTMLDivElement asElement() {
        return column;
    }

    public enum OnXLarge {
        one("col-xl-1"),
        two("col-xl-2"),
        three("col-xl-3"),
        four("col-xl-4"),
        five("col-xl-5"),
        six("col-xl-6"),
        seven("col-xl-7"),
        eight("col-xl-8"),
        nine("col-xl-9"),
        ten("col-xl-10"),
        eleven("col-xl-11"),
        twelve("col-xl-12");

        private String style;

        OnXLarge(String style) {
            this.style = style;
        }

        public static OnXLarge of(int large) {
            return OnXLarge.valueOf(asNumberString(large));
        }

        public String getStyle() {
            return style;
        }
    }

    public enum OnLarge {
        one("col-lg-1"),
        two("col-lg-2"),
        three("col-lg-3"),
        four("col-lg-4"),
        five("col-lg-5"),
        six("col-lg-6"),
        seven("col-lg-7"),
        eight("col-lg-8"),
        nine("col-lg-9"),
        ten("col-lg-10"),
        eleven("col-lg-11"),
        twelve("col-lg-12");

        private String style;

        OnLarge(String style) {
            this.style = style;
        }

        public static OnLarge of(int large) {
            return OnLarge.valueOf(asNumberString(large));
        }

        public String getStyle() {
            return style;
        }
    }

    public enum OnMedium {
        one("col-md-1"),
        two("col-md-2"),
        three("col-md-3"),
        four("col-md-4"),
        five("col-md-5"),
        six("col-md-6"),
        seven("col-md-7"),
        eight("col-md-8"),
        nine("col-md-9"),
        ten("col-md-10"),
        eleven("col-md-11"),
        twelve("col-md-12");

        private String style;

        OnMedium(String style) {
            this.style = style;
        }

        public static OnMedium of(int medium) {
            return OnMedium.valueOf(asNumberString(medium));
        }

        public String getStyle() {
            return style;
        }
    }

    public enum OnSmall {
        one("col-sm-1"),
        two("col-sm-2"),
        three("col-sm-3"),
        four("col-sm-4"),
        five("col-sm-5"),
        six("col-sm-6"),
        seven("col-sm-7"),
        eight("col-sm-8"),
        nine("col-sm-9"),
        ten("col-sm-10"),
        eleven("col-sm-11"),
        twelve("col-sm-12");

        private String style;

        OnSmall(String style) {
            this.style = style;
        }

        public static OnSmall of(int small) {
            return OnSmall.valueOf(asNumberString(small));
        }

        public String getStyle() {
            return style;
        }
    }

    public enum OnXSmall {
        one("col-xs-1"),
        two("col-xs-2"),
        three("col-xs-3"),
        four("col-xs-4"),
        five("col-xs-5"),
        six("col-xs-6"),
        seven("col-xs-7"),
        eight("col-xs-8"),
        nine("col-xs-9"),
        ten("col-xs-10"),
        eleven("col-xs-11"),
        twelve("col-xs-12");

        private String style;

        OnXSmall(String style) {
            this.style = style;
        }

        public static OnXSmall of(int xsmall) {
            return OnXSmall.valueOf(asNumberString(xsmall));
        }

        public String getStyle() {
            return style;
        }
    }

    private static String asNumberString(int size) {
        switch (size) {
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "four";
            case 5:
                return "five";
            case 6:
                return "six";
            case 7:
                return "seven";
            case 8:
                return "eight";
            case 9:
                return "nine";
            case 10:
                return "ten";
            case 11:
                return "eleven";
            case 12:
                return "twelve";
            default:
                return "twelve";
        }
    }

}
