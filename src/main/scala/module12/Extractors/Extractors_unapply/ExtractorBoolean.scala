package module12.Extractors.Extractors_unapply

object ExtractorBoolean extends App {

                def unapply(x:Int): Boolean = {

                        if (x % 3 == 0)
                                {
                                        true
                                        }
                                else
                                false
                        }

                // Displays output in Boolean type
                println ("The Unapply method returns : " + unapply(12))
                println ("The Unapply method returns : " + unapply(35))

                }
