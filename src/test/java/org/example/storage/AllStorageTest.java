package org.example.storage;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
  AbstractArrayStorageTest.class,
  AbstractStorageTest.class,
  ArrayStorageTest.class,
  ListStorageTest.class,
  MapUuidStorageTest.class,
  MapFullNameStorageTest.class,
  SortedArrayStorageTest.class
})
public class AllStorageTest {}
